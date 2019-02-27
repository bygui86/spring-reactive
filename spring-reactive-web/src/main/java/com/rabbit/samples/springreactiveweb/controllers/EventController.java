package com.rabbit.samples.springreactiveweb.controllers;

import com.rabbit.samples.springreactiveweb.domain.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 27 Feb 2019
 */
@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {

	@GetMapping("/{id}")
	public Mono<Event> getById(@PathVariable final long id){

		log.info("get event by id {}", id);

		return Mono.just(
			Event.builder().id(id).when(new Date()).build()
		);
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> getAll() {

		log.info("get all events");

		Flux<Event> eventFlux = Flux.fromStream(
				Stream.generate(
						() -> Event.builder().id(System.currentTimeMillis()).when(new Date()).build()
				)
		);

		Flux<Long> intervalFlux = Flux.interval(
				Duration.ofSeconds(1)
		);

		return Flux
				.zip(eventFlux, intervalFlux)
				.map(Tuple2::getT1);
	}

}
