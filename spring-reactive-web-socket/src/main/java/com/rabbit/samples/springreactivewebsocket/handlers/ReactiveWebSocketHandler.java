package com.rabbit.samples.springreactivewebsocket.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbit.samples.springreactivewebsocket.events.Event;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
public class ReactiveWebSocketHandler implements WebSocketHandler {

	ObjectMapper objectMapper;

	@Override
	public Mono<Void> handle(final WebSocketSession webSocketSession) {

		log.info("handle feed...");

		Flux<String> employeeCreationEvent = Flux.generate(
				stringSynchronousSink -> sinkEvent(
						stringSynchronousSink,
						Event.builder().id(randomUUID().toString()).time(now().toString()).build()
				)
		);

		return webSocketSession.send(
				employeeCreationEvent
				.map(webSocketSession::textMessage)
				.delayElements(Duration.ofSeconds(1))
		);
	}

	private void sinkEvent(final SynchronousSink<String> stringSynchronousSink, final Event event) {

		try {
			stringSynchronousSink.next(getObjectMapper().writeValueAsString(event));
		} catch (JsonProcessingException e) {
			stringSynchronousSink.error(e);
		}
	}

}
