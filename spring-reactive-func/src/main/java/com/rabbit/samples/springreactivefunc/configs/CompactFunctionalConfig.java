package com.rabbit.samples.springreactivefunc.configs;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.domain.Event;
import com.rabbit.samples.springreactivefunc.filters.EmployeeFilterHandler;
import com.rabbit.samples.springreactivefunc.filters.EventFilterHandler;
import com.rabbit.samples.springreactivefunc.filters.GenericFilterHandler;
import com.rabbit.samples.springreactivefunc.repos.EmployeeRepository;
import com.rabbit.samples.springreactivefunc.repos.EventRepository;
import com.rabbit.samples.springreactivefunc.repos.impl.StaticEmployeeRepository;
import com.rabbit.samples.springreactivefunc.repos.impl.StaticEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@Configuration
@Profile("compact")
public class CompactFunctionalConfig {

	@Bean
	EmployeeRepository employeeRepository() {

		return new StaticEmployeeRepository();
	}

	@Bean
	EventRepository eventRepository() {

		return new StaticEventRepository();
	}

	@Bean
	GenericFilterHandler genericFilterHandler() {

		return new GenericFilterHandler();
	}

	@Bean
	EmployeeFilterHandler employeeFilterHandler() {

		return new EmployeeFilterHandler();
	}

	@Bean
	EventFilterHandler eventFilterHandler() {

		return new EventFilterHandler();
	}

	@Bean
	RouterFunction<ServerResponse> allRoutes() {

		return route()

				// EMPLOYEES
				.path(
						"/employees",
						() -> route()
								.nest(
										accept(APPLICATION_JSON),
										builder ->
												builder
														.GET(
																"/{id}",
																serverRequest ->
																		ok()
																				.contentType(APPLICATION_JSON)
																				.body(employeeRepository().findById(serverRequest.pathVariable("id")), Employee.class)
														)
														.GET(
																"",
																serverRequest ->
																		ok()
																				// .contentType(MediaType.TEXT_EVENT_STREAM)
																				.contentType(MediaType.APPLICATION_STREAM_JSON)
																				.body(employeeRepository().findAll(), Employee.class)
														)
														.PUT(
																"",
																serverRequest ->
																		ok()
																				.contentType(APPLICATION_JSON)
																				.body(serverRequest.bodyToMono(Employee.class).doOnNext(employeeRepository()::update), Employee.class)
														)
								)
								.build()
								.filter(employeeFilterHandler()::requestLogging)
				)

				// EVENTS
				.path(
						"/events",
						() -> route()
								.nest(
										accept(APPLICATION_JSON),
										builder ->
												builder
														.GET(
																"/{id}",
																serverRequest ->
																		ok()
																				.contentType(APPLICATION_JSON)
																				.body(eventRepository().findById(Long.valueOf(serverRequest.pathVariable("id"))), Event.class)
														)
														.GET(
																"",
																serverRequest ->
																		ok()
																				// .contentType(MediaType.TEXT_EVENT_STREAM)
																				.contentType(MediaType.APPLICATION_STREAM_JSON)
																				.body(eventRepository().findAll(), Event.class)
														)
								).build()
								.filter(eventFilterHandler()::requestLogging)
				)
				.filter(genericFilterHandler()::performanceLogging)
				.build();
	}


}
