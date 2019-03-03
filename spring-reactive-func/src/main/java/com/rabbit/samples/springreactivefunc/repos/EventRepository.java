package com.rabbit.samples.springreactivefunc.repos;

import com.rabbit.samples.springreactivefunc.domain.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
public interface EventRepository {

	Flux<Event> findAll();

	Mono<Event> findById(final long id);

}
