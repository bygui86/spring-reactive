package com.rabbit.samples.springreactivewebsocket.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import java.net.URI;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
public class EmployeeWebSocketClient {

	public void subscribeToFeeds() {

		WebSocketClient client = new ReactorNettyWebSocketClient();

		client
				.execute(
						URI.create("ws://localhost:8080/employee-feed"),
						session -> session
								.receive()
								.map(WebSocketMessage::getPayloadAsText)
								.doOnNext(log::info)
								.then()
				)
				.block(); // to subscribe and return the value
	}

}
