package com.rabbit.samples.springreactiver2dbc.repos;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
// @Repository
// public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
// public interface EmployeeRepository {

	// Mono<Integer> count();
	//
	// Flux<Employee> findAll();
	//
	// Mono<Employee> findById(final String id);
	//
	// Mono<Void> deleteAll();
	//
	// Mono<Void> deleteById(final String id);
	//
	// Mono<String> save(final Employee employee);
	//
	// void init();

}
