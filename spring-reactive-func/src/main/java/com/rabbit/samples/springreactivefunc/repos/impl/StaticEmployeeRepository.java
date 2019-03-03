package com.rabbit.samples.springreactivefunc.repos.impl;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.repos.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
public class StaticEmployeeRepository implements EmployeeRepository {

	static Map<String, Employee> employeeData;

	static Map<String, String> employeeAccessData;

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

		Employee existingEmployee = employeeData.get(employee.getId());

		if(existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			return Mono.just(existingEmployee);
		}

		return Mono.empty();
	}

	static {

		initData();
		initAccessData();
	}

	private static void initData() {

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

	private static void initAccessData() {

		employeeAccessData = new HashMap<>();
		employeeAccessData.put("1", "Employee 1 Access Key");
		employeeAccessData.put("2", "Employee 2 Access Key");
		employeeAccessData.put("3", "Employee 3 Access Key");
		employeeAccessData.put("4", "Employee 4 Access Key");
		employeeAccessData.put("5", "Employee 5 Access Key");
		employeeAccessData.put("6", "Employee 6 Access Key");
		employeeAccessData.put("7", "Employee 7 Access Key");
		employeeAccessData.put("8", "Employee 8 Access Key");
		employeeAccessData.put("9", "Employee 9 Access Key");
		employeeAccessData.put("10", "Employee 10 Access Key");
	}

}
