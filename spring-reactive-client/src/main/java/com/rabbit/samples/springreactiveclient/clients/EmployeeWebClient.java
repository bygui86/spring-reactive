package com.rabbit.samples.springreactiveclient.clients;

import com.rabbit.samples.springreactiveclient.domain.Employee;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
public class EmployeeWebClient {

	final String URI_ROOT = "/employees";

	WebClient webClient;

	@Scheduled(initialDelay = 5000, fixedRate = 1000)
	public void update() {

		String id = "1";

		log.info("update employee id {}", id);

		getWebClient()
				.put()
				.uri(URI_ROOT)
				.body(BodyInserters.fromObject(Employee.builder().id(id).name("Matteo Baiguini").build()))
		;
	}

	@Scheduled(initialDelay = 1000, fixedRate = 3000)
	public void getById() {

		log.info("scheduled get by id...");

		getWebClient()
				.get()
				.uri(URI_ROOT + "/{id}", generateRandomId())
				.retrieve()
				.bodyToMono(Employee.class)
				.subscribe(this::logInfoEmployee)
		;
	}

	@Scheduled(initialDelay = 3000, fixedRate = 10000)
	public void getAll() {

		log.info("scheduled get all...");

		getWebClient()
				.get()
				.uri(URI_ROOT)
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
