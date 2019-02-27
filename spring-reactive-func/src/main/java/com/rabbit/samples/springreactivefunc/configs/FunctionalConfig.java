package com.rabbit.samples.springreactivefunc.configs;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.repos.EmployeeRepository;
import com.rabbit.samples.springreactivefunc.repos.impl.StaticEmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Configuration
public class FunctionalConfig {

	@Bean
	EmployeeRepository employeeRepository() {
		return new StaticEmployeeRepository();
	}

	@Bean
	RouterFunction<ServerResponse> allRoutes() {

		return nest(
				path("/employees"),

				route(
						method(HttpMethod.GET),
						serverRequest ->
								ok().body(employeeRepository().findAll(), Employee.class)
				)
				.andRoute(
						GET("/{id}"),
						serverRequest ->
								ok().body(employeeRepository().findById(serverRequest.pathVariable("id")), Employee.class)
				)
				.andRoute(
						method(HttpMethod.PUT),
						serverRequest ->
								serverRequest
										.body(toMono(Employee.class))
										.doOnNext(employeeRepository()::update)
										.then(ok().build())
				)
		);

		// return route(
		// 				GET("/employees"),
		// 				req -> ok()
		// 						.body(employeeRepository().findAll(), Employee.class)
		// 		)
		// 		.and(route(
		// 				GET("/employees/{id}"),
		// 				req -> ok()
		// 						.body(employeeRepository().findById(req.pathVariable("id")), Employee.class)
		// 		))
		// 		.and(route(
		// 			PUT("/employees"),
		// 			req -> req
		// 					.body(toMono(Employee.class))
		// 					.doOnNext(employeeRepository()::update)
		// 					.then(ok().build())
		// 		));
	}

}
