package com.rabbit.samples.springreactivewebsocketclient.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Configuration
public class WebSocketConfig {

	@Bean
	public WebSocketClient webSocketClient() {

		return new ReactorNettyWebSocketClient();
	}

}
