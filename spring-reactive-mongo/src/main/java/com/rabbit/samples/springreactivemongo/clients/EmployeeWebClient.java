package com.rabbit.samples.springreactivemongo.clients;

import com.rabbit.samples.springreactivemongo.domain.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

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

	WebClient webClient = WebClient.create("http://localhost:8080");

	int counter = 1;

	@Scheduled(initialDelay = 3000, fixedRate = 3000)
	public void getById() {

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

	@Scheduled(initialDelay = 1000, fixedRate = 3000)
	public void insert() {

		Employee employeeRequest = Employee.builder().name("Employee " + counter++).build();

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

	@Scheduled(initialDelay = 3000, fixedRate = 10000)
	public void getAll() {

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
