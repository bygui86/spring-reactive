package com.rabbit.samples.springreactiver2dbc.clients;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
// import reactor.test.StepVerifier;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PROTECTED)
@Component
public class EmployeeWebClient {

	DatabaseClient databaseClient;

	WebClient webClient = WebClient.create("http://localhost:8080");

	long counter = 1;

	public EmployeeWebClient(final DatabaseClient databaseClient) {

		this.databaseClient = databaseClient;
	}

	// @PostConstruct
	public void initDb() {

		log.info("Init reactive DB");

		List<String> statements =
				Arrays.asList(
						"DROP TABLE IF EXISTS employee;",
						"CREATE TABLE employee ( id integer PRIMARY KEY, name VARCHAR(255) NOT NULL );"
				);

		statements.forEach(
				it -> getDatabaseClient()
						.execute()
						.sql(it)
						.fetch()
						.rowsUpdated()
						// .as(StepVerifier::create)
						// .verifyComplete()
						.then()
						.block()
		);

		// log.info("Drop table employee");
		//
		// getDatabaseClient()
		// 		.execute()
		// 		.sql("DROP TABLE IF EXISTS employee;")
		// 		.fetch()
		// 		.rowsUpdated()
		// 	;
		//
		// log.info("Create table employee");
		//
		// getDatabaseClient()
		// 		.execute()
		// 		// .sql("CREATE TABLE employee (id varchar PRIMARY KEY, name varchar);")
		// 		.sql("CREATE TABLE employee (id integer PRIMARY KEY, name VARCHAR(250) NOT NULL);")
		// 		.fetch()
		// 		.rowsUpdated()
		// 	;
	}

	// @Scheduled(initialDelay = 3000, fixedRate = 10000)
	public void insert() {

		log.info("Scheduled insert");

		Employee employeeRequest = Employee.builder().id(counter).name("Employee " + counter).build();
		counter++;

		getWebClient()
				.post()
				.uri("/employees")
				.body(BodyInserters.fromObject(employeeRequest))
				.retrieve()
				.bodyToMono(Employee.class)
				.subscribe(employeeResponse -> {
					log.info("INSERT: {}", employeeResponse);
				})
		;
	}

	// @Scheduled(initialDelay = 5000, fixedRate = 3000)
	public void getById() {

		log.info("Scheduled getById");

		getWebClient()
				.get()
				.uri("/employees/{id}", generateRandomId())
				.retrieve()
				.bodyToMono(Employee.class)
				.subscribe(employee -> {
					log.info("GET: {}", employee);
				})
		;
	}

	// @Scheduled(initialDelay = 5000, fixedRate = 10000)
	public void getAll() {

		log.info("Scheduled getAll");

		getWebClient()
				.get()
				.uri("/employees")
				.retrieve()
				.bodyToFlux(Employee.class)
				.subscribe(employee -> {
					log.info("GET-ALL: {}", employee);
				})
		;
	}

	private String generateRandomId() {

		return Integer.toString(new Random().nextInt(10));
	}

}
