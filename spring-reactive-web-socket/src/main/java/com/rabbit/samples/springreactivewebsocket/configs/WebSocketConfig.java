package com.rabbit.samples.springreactivewebsocket.configs;

import com.rabbit.samples.springreactivewebsocket.handlers.EmployeeWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Configuration
public class WebSocketConfig {

	@Bean
	public WebSocketHandlerAdapter webSocketHandlerAdapter() {

		return new WebSocketHandlerAdapter();
	}

	@Bean
	public HandlerMapping handlerMapping() {

		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setUrlMap(buildWebSocketHandlerMap());
		mapping.setOrder(10);
		return mapping;
	}

	private Map<String, WebSocketHandler> buildWebSocketHandlerMap() {

		Map<String, WebSocketHandler> map = new HashMap<>();
		map.put("/employee-feed", new EmployeeWebSocketHandler());
		return map;
	}

}
