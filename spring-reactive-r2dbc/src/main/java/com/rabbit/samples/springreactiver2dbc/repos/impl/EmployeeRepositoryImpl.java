package com.rabbit.samples.springreactiver2dbc.repos.impl;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import com.rabbit.samples.springreactiver2dbc.repos.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 21 Feb 2019
 */
// @Slf4j
// @FieldDefaults(level = AccessLevel.PRIVATE)
// @AllArgsConstructor
// @Getter(AccessLevel.PROTECTED)
// @Component
// public class EmployeeRepositoryImpl implements EmployeeRepository {
public class EmployeeRepositoryImpl {

	// DatabaseClient databaseClient;

	// @Override
	// public Mono<Integer> count() {
	//
	// 	return getDatabaseClient()
	// 			.execute()
	// 			.sql("SELECT COUNT(*) FROM employees")
	// 			.as(Integer.class)
	// 			.fetch()
	// 			.one();
	// }

	// @Override
	// public Flux<Employee> findAll() {
	//
	// 	return getDatabaseClient()
	// 			.select()
	// 			.from("employees")
	// 			.as(Employee.class)
	// 			.fetch()
	// 			.all();
	// }

	// @Override
	// public Mono<Employee> findById(final String id) {
	//
	// 	return getDatabaseClient()
	// 			.execute()
	// 			.sql("SELECT * FROM employees WHERE id = $1")
	// 			.bind(1, id)
	// 			.as(Employee.class)
	// 			.fetch()
	// 			.one();
	// }

	// @Override
	// public Mono<Void> deleteAll() {
	//
	// 	return getDatabaseClient()
	// 			.execute()
	// 			.sql("DELETE FROM employees")
	// 			.fetch()
	// 			.one()
	// 			.then();
	// }

	// @Override
	// public Mono<Void> deleteById(final String id) {
	//
	// 	return getDatabaseClient()
	// 			.execute()
	// 			.sql("DELETE FROM employees WHERE id = $1")
	// 			.bind(1, id)
	// 			.fetch()
	// 			.one()
	// 			.then();
	// }

	// @Override
	// public Mono<String> save(final Employee employee) {
	//
	// 	return getDatabaseClient()
	// 			.insert()
	// 			.into(Employee.class)
	// 			.table("employees")
	// 			.using(employee)
	// 			.map((row, rowMetadata) -> row.get("id", String.class))
	// 			.one();
	// }

	// @Override
	// public void init() {
	//
	// 	log.info("Drop table employee");
	//
	// 	getDatabaseClient()
	// 			.execute()
	// 			.sql("DROP TABLE IF EXISTS employee;")
	// 			.then()
	// 			.block();
	//
	// 	log.info("Create table employee");
	//
	// 	getDatabaseClient()
	// 			.execute()
	// 			// .sql("CREATE TABLE employee (id varchar PRIMARY KEY, name varchar);")
	// 			.sql("CREATE TABLE employee (id SERIAL PRIMARY KEY, name VARCHAR(250) NOT NULL);")
	// 			.then()
	// 			.then(save(Employee.builder().id("1").name("Employee 1").build()))
	// 			.then(save(Employee.builder().id("2").name("Employee 2").build()))
	// 			.then(save(Employee.builder().id("3").name("Employee 3").build()))
	// 			.block();
	// }

}
