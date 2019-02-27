package com.rabbit.samples.springreactiveclient.clients;

import com.rabbit.samples.springreactiveclient.domain.Employee;
import com.rabbit.samples.springreactiveclient.domain.Event;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.Random;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
public class EventWebClient {

	final String URI_ROOT = "/events";

	WebClient webClient;

	@PostConstruct
	public void postConstruct() {

		subscribeMono();

		subscribeFlux();
	}

	public void subscribeMono() {

		log.info("subscribing event mono...");

		getWebClient()
				.get()
				.uri(URI_ROOT + "/{id}", generateRandomId())
				.retrieve()
				.bodyToMono(Event.class)
				.subscribe(this::logInfoEvent)
		;
	}

	public void subscribeFlux() {

		log.info("subscribing event flux...");

		getWebClient()
				.get()
				.uri(URI_ROOT)
				.accept(MediaType.TEXT_EVENT_STREAM)
				.retrieve()
				.bodyToFlux(Event.class)
				.subscribe(this::logInfoEvent)
		;
	}

	private String generateRandomId() {

		return Integer.toString(new Random().nextInt(100));
	}

	private void logInfoEvent(final Event event) {

		log.info(event.toString());
	}

}
