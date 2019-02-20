package com.rabbit.samples.springreactivewebsocket.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.samples.springreactivewebsocket.events.EmployeeCreationEvent;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Getter(AccessLevel.PROTECTED)
@Component
public class EmployeeWebSocketHandler implements WebSocketHandler {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Mono<Void> handle(final WebSocketSession webSocketSession) {

		Flux<String> employeeCreationEvent = Flux.generate(
				stringSynchronousSink -> sinkEvent(
						stringSynchronousSink,
						new EmployeeCreationEvent(randomUUID().toString(), now().toString())
				)
		);

		return webSocketSession.send(
				employeeCreationEvent
				.map(webSocketSession::textMessage)
				.delayElements(Duration.ofSeconds(1))
		);
	}

	private void sinkEvent(final SynchronousSink<String> stringSynchronousSink, final EmployeeCreationEvent event) {

		try {
			stringSynchronousSink.next(getObjectMapper().writeValueAsString(event));
		} catch (JsonProcessingException e) {
			stringSynchronousSink.error(e);
		}
	}

}
