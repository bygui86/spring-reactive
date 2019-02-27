package com.rabbit.samples.springreactivewebsocketclient.listeners;

import com.rabbit.samples.springreactivewebsocketclient.clients.ReactiveWebSocketClient;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 28 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
public class ApplicationEventListener {

	ReactiveWebSocketClient reactiveWebSocketClient;

	// @EventListener
	// public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
	//
	// 	log.info("application started...");
	//
	// 	getReactiveWebSocketClient().subscribeToFeeds();
	// }

	@EventListener
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

		log.info("application ready...");

		getReactiveWebSocketClient().subscribeToFeeds();
	}

}
