package com.rabbit.samples.springreactivewebsocketclient.clients;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import javax.annotation.PostConstruct;
import java.net.URI;


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
public class ReactiveWebSocketClient {

	WebSocketClient webSocketClient;

	public void subscribeToFeeds() {

		log.info("subscribing to feeds...");

		getWebSocketClient()
				.execute(
						URI.create("ws://localhost:8080/feeds"),
						session -> session
								.receive()
								.map(WebSocketMessage::getPayloadAsText)
								.doOnNext(log::info)
								.then()
				)
				.block(); // to subscribe and return the value
	}

}
