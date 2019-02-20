package com.rabbit.samples.springreactiveweb.repos;

import com.rabbit.samples.springreactiveweb.domain.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
public interface EmployeeRepository {

	Flux<Employee> findAll();

	Mono<Employee> findById(final String id);

	Mono<Employee> update(final Employee employee);

}
