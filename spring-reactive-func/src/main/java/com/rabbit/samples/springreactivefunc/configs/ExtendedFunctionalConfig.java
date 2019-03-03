package com.rabbit.samples.springreactivefunc.configs;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.domain.Event;
import com.rabbit.samples.springreactivefunc.repos.EmployeeRepository;
import com.rabbit.samples.springreactivefunc.repos.EventRepository;
import com.rabbit.samples.springreactivefunc.repos.impl.StaticEmployeeRepository;
import com.rabbit.samples.springreactivefunc.repos.impl.StaticEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyExtractors.toMono;
// v5.0
// import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
// v5.1
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Configuration
@Profile("extended")
public class ExtendedFunctionalConfig {

	@Bean
	EmployeeRepository employeeRepository() {

		return new StaticEmployeeRepository();
	}

	@Bean
	EventRepository eventRepository() {

		return new StaticEventRepository();
	}

	@Bean
	RouterFunction<ServerResponse> getEmployeeByIdRoute() {

		// v5.0
		// return route(
		// 		GET("/employees/{id}"),
		//      accept(APPLICATION_JSON),
		// 		serverRequest ->
		// 				ok().body(employeeRepository().findById(serverRequest.pathVariable("id")), Employee.class)
		// );

		// v5.1
		return route()
				.GET(
						"/employees/{id}",
						serverRequest ->
								ok().body(employeeRepository().findById(serverRequest.pathVariable("id")), Employee.class)
				)
				.build();
	}

	@Bean
	RouterFunction<ServerResponse> getAllEmployeesRoute() {

		return route()
				.GET(
						"/employees",
						serverRequest ->
								ok()
										// .contentType(MediaType.TEXT_EVENT_STREAM)
										.contentType(MediaType.APPLICATION_STREAM_JSON)
										.body(employeeRepository().findAll(), Employee.class)
				)
				.build();
	}

	@Bean
	RouterFunction<ServerResponse> updateEmployeeRoute() {

		return route()
				.PUT(
						"/employees",
						accept(APPLICATION_JSON),
						serverRequest ->
								serverRequest
										.body(toMono(Employee.class))
										.doOnNext(employeeRepository()::update)
										.then(ok().build())
				)
				.build();
	}

	@Bean
	RouterFunction<ServerResponse> getEventByIdRoute() {

		return route()
				.GET(
						"/events/{id}",
						serverRequest ->
								ok().body(eventRepository().findById(Long.valueOf(serverRequest.pathVariable("id"))), Event.class)
				)
				.build();
	}

	@Bean
	RouterFunction<ServerResponse> getAllEventsRoute() {

		return route()
				.GET(
						"/events",
						serverRequest ->
								ok()
										// .contentType(MediaType.TEXT_EVENT_STREAM)
										.contentType(MediaType.APPLICATION_STREAM_JSON)
										.body(eventRepository().findAll(), Event.class)
				)
				.build();
	}

}
