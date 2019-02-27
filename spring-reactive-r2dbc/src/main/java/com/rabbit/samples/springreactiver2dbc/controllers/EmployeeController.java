package com.rabbit.samples.springreactiver2dbc.controllers;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import com.rabbit.samples.springreactiver2dbc.repos.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	EmployeeRepository employeeRepository;

	@GetMapping
	private Flux<Employee> getAll() {

		log.info("get all employees");

		return getEmployeeRepository().findAll();
	}

	@GetMapping("/{id}")
	// private Mono<Employee> getById(@PathVariable final String id) {
	private Mono<Employee> getById(@PathVariable final Long id) {

		log.info("get employee by id {}", id);

		return getEmployeeRepository().findById(id);
	}

	@PostMapping
	// private Mono<String> insert(@RequestBody final Employee employee) {
	private Mono<Employee> insert(@RequestBody final Employee employee) {

		log.info("insert employee {}", employee);

		return save(employee);
	}

	@PutMapping
	// private Mono<String> update(@RequestBody final Employee employee) {
	private Mono<Employee> update(@RequestBody final Employee employee) {

		log.info("update employee {}", employee);

		return save(employee);
	}

	@DeleteMapping
	private Mono<Void> deleteAll() {

		log.info("delete all employees");

		return getEmployeeRepository().deleteAll();
	}

	@DeleteMapping("/{id}")
	// private Mono<Void> deleteById(@PathVariable final String id) {
	private Mono<Void> deleteById(@PathVariable final Long id) {

		log.info("delete employee by id {}", id);

		return getEmployeeRepository().deleteById(id);
	}

	// private Mono<String> save(@RequestBody final Employee employee) {
	private Mono<Employee> save(@RequestBody final Employee employee) {

		return getEmployeeRepository().save(employee);
	}

}
