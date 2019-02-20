package com.rabbit.samples.springreactiveweb.controllers;

import com.rabbit.samples.springreactiveweb.domain.Employee;
import com.rabbit.samples.springreactiveweb.repos.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PutMapping
	private Mono<Employee> update(@RequestBody final Employee employee) {

		return getEmployeeRepository().update(employee);
	}

}
