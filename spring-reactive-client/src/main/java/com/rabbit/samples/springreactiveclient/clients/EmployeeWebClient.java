package com.rabbit.samples.springreactiveclient.clients;

import com.rabbit.samples.springreactiveclient.domain.Employee;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
@Profile("web-func")
public class EmployeeWebClient {

	final String URI_ROOT = "/employees";

	WebClient webClient;

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

	@Scheduled(initialDelay = 5000, fixedRate = 10000)
	public void update() {

		final Employee employee = Employee.builder().id("1").name("Matteo Baiguini").build();
		log.info("scheduled update employee {}...", employee);

		getWebClient()
				.put()
				.uri(URI_ROOT)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("Authorization", "Basic " + Base64Utils
						.encodeToString(("admin:secret").getBytes(UTF_8)))
				.body(Mono.just(employee), Employee.class)
				.retrieve()
				.bodyToMono(Employee.class)
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
