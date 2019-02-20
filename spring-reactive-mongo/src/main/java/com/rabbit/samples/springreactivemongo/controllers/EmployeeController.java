package com.rabbit.samples.springreactivemongo.controllers;

import com.rabbit.samples.springreactivemongo.domain.Employee;
import com.rabbit.samples.springreactivemongo.repos.EmployeeRepository;
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

		return getEmployeeRepository().findAll();
	}

	@GetMapping("/{id}")
	private Mono<Employee> getById(@PathVariable final String id) {

		return getEmployeeRepository().findById(id);
	}

	@PostMapping
	private Mono<Employee> insert(@RequestBody final Employee employee) {

		return save(employee);
	}

	@PutMapping
	private Mono<Employee> update(@RequestBody final Employee employee) {

		return save(employee);
	}

	@DeleteMapping
	private Mono<Void> deleteAll() {

		return getEmployeeRepository().deleteAll();
	}

	@DeleteMapping("/{id}")
	private Mono<Void> deleteById(@PathVariable final String id) {

		return getEmployeeRepository().deleteById(id);
	}

	private Mono<Employee> save(@RequestBody final Employee employee) {

		return getEmployeeRepository().save(employee);
	}

}
