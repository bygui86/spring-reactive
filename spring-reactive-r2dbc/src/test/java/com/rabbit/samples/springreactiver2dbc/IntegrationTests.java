package com.rabbit.samples.springreactiver2dbc;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import com.rabbit.samples.springreactiver2dbc.repos.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 22 Apr 2019
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfrastructureConfiguration.class)
public class IntegrationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DatabaseClient databaseClient;

	@Before
	public void setUp() {

		Hooks.onOperatorDebug();

		List<String> statements = Arrays.asList(
				"DROP TABLE IF EXISTS employee;",
				"CREATE TABLE IF NOT EXISTS employee (id varchar PRIMARY KEY, name varchar);");

		statements.forEach(it -> databaseClient.execute()
				.sql(it)
				.fetch()
				.rowsUpdated()
				.as(StepVerifier::create)
				.verifyComplete());
	}

	@Test
	public void executesFindAll() {

		Employee matt = new Employee("mattb", "matteo baiguini");
		Employee john = new Employee("johnd", "john doe");

		insertEmployees(matt, john);

		employeeRepository.findAll()
				.doOnNext(
						employee -> log.warn("Employee {}", employee)
				)
				.as(StepVerifier::create)
				// .assertNext(matt::equals)
				// .assertNext(john::equals)
				.verifyComplete()
		;
	}

	private void insertEmployees(Employee... customers) {

		employeeRepository
				.saveAll(Arrays.asList(customers))
				.as(StepVerifier::create)
				.expectNextCount(2)
				.verifyComplete();
	}

}