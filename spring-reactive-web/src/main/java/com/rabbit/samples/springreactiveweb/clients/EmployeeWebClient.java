package com.rabbit.samples.springreactiveweb.clients;

import com.rabbit.samples.springreactiveweb.domain.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@Getter(AccessLevel.PROTECTED)
@Component
public class EmployeeWebClient {

	WebClient webClient = WebClient.create("http://localhost:8080");

	@Scheduled(initialDelay = 1000, fixedRate = 3000)
	public void consumeMono() {

		getWebClient()
				.get()
				.uri("/employees/{id}", generateRandomId())
				.retrieve()
				.bodyToMono(Employee.class)
				.subscribe(this::logInfoEmployee)
		;
	}

	@Scheduled(initialDelay = 3000, fixedRate = 10000)
	public void consumeFlux() {

		getWebClient()
				.get()
				.uri("/employees")
				.retrieve()
				.bodyToFlux(Employee.class)
				.subscribe(this::logInfoEmployee)
		;
	}

	private String generateRandomId() {

		return Integer.toString(new Random().nextInt(10));
	}

	private void logInfoEmployee(final Employee employee) {

		log.info(employee.toString());
	}

}
