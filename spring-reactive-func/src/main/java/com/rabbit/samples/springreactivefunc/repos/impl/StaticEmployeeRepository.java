package com.rabbit.samples.springreactivefunc.repos.impl;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.repos.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
public class StaticEmployeeRepository implements EmployeeRepository {

	private static Map<String, Employee> employeeData;

	@PostConstruct
	public void postConstruct() {

		initData();
	}

	public Flux<Employee> findAll() {

		log.debug("find all");

		return Flux.fromIterable(employeeData.values());
	}

	public Mono<Employee> findById(final String id) {

		log.debug("find by id {}", id);

		final Employee employee = employeeData.get(id);
		return employee != null ? Mono.just(employee) : Mono.empty();
	}

	public Mono<Employee> update(final Employee employee) {

		log.debug("update {}", employee);

		Employee currentEmployee = employeeData.get(employee.getId());

		if(currentEmployee != null) {
			currentEmployee.setName(employee.getName());
			return Mono.just(currentEmployee);
		}

		return Mono.empty();
	}

	public void initData() {

		employeeData = new HashMap<>();
		employeeData.put("1", new Employee("1","Employee 1"));
		employeeData.put("2", new Employee("2","Employee 2"));
		employeeData.put("3", new Employee("3","Employee 3"));
		employeeData.put("4", new Employee("4","Employee 4"));
		employeeData.put("5", new Employee("5","Employee 5"));
		employeeData.put("6", new Employee("6","Employee 6"));
		employeeData.put("7", new Employee("7","Employee 7"));
		employeeData.put("8", new Employee("8","Employee 8"));
		employeeData.put("9", new Employee("9","Employee 9"));
		employeeData.put("10", new Employee("10","Employee 10"));
	}

}
