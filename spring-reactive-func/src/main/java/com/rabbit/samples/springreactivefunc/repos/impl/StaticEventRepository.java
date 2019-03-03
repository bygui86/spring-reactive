package com.rabbit.samples.springreactivefunc.repos.impl;

import com.rabbit.samples.springreactivefunc.domain.Event;
import com.rabbit.samples.springreactivefunc.repos.EventRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 28 Feb 2019
 */
@Slf4j
public class StaticEventRepository implements EventRepository {

	@Override
	public Flux<Event> findAll() {

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

	@Override
	public Mono<Event> findById(final long id) {

		log.info("get event by id {}", id);

		return Mono.just(
				Event.builder().id(id).when(new Date()).build()
		);
	}

}
