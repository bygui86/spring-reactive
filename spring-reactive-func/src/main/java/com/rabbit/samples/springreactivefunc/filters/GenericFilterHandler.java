package com.rabbit.samples.springreactivefunc.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Mar 2019
 */
@Slf4j
public class GenericFilterHandler {

	public Mono<ServerResponse> performanceLogging(ServerRequest serverRequest, HandlerFunction<ServerResponse> next) {

		Instant start = Instant.now();
		Mono<ServerResponse> response = next.handle(serverRequest);
		Duration duration = Duration.between(start, Instant.now());
		log.debug("Processing request {} took {} ms ", serverRequest, duration.toMillis());
		return response;
	}

}
