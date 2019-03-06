package com.rabbit.samples.springreactivefunc.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Mar 2019
 */
@Slf4j
public abstract class ObjectFilterHandler {

	public Mono<ServerResponse> requestLogging(final ServerRequest serverRequest, final HandlerFunction<ServerResponse> next) {

		String uri = serverRequest.uri().toString();
		String method = serverRequest.methodName();
		String contentType = serverRequest.headers().contentType().isPresent() ? serverRequest.headers().contentType().get().toString() : "NOT SPECIFIED";
		String acceptType = serverRequest.headers().accept().toString();
		String characterSet = serverRequest.headers().acceptCharset().toString();
		Object bodyData = getBodyObject(serverRequest);

		log.debug("URI: {}", uri);
		log.debug("Method: {}", method);
		log.debug("ContentType: {}", contentType);
		log.debug("Accept: {}", acceptType);
		log.debug("Charset: {}", characterSet);
		log.debug("Body: {}", bodyData != null ? bodyData.toString() : "NOT PRESENT");

		return next.handle(serverRequest);
	}

	abstract Object getBodyObject(final ServerRequest serverRequest);

}
