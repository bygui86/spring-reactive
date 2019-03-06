package com.rabbit.samples.springreactiveclient.clients;

import com.rabbit.samples.springreactiveclient.domain.Employee;
import com.rabbit.samples.springreactiveclient.domain.Event;
import com.rabbit.samples.springreactiveclient.domain.R2dbcEmployee;
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
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 05 Mar 2019
 */
@Slf4j
@AllArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Component
@Profile("r2dbc")
public class R2dbcWebClient {

	final String URI_ROOT = "/employees";

	WebClient webClient;

	@PostConstruct
	public void postConstruct() {

		insert(1, "Matteo Baiguini");
		// insert(2, "John Doe");
		// insert(3, "Jane Doe");
		//
		// getById(1);
		//
		// getAll();
	}

	public void insert(final Integer id, final String name) {

		final R2dbcEmployee employee = R2dbcEmployee.builder().id(id).name(name).build();
		log.info("scheduled insert employee {}", employee);

		getWebClient()
				.post()
				.uri(URI_ROOT)
				.body(Mono.just(employee), R2dbcEmployee.class)
				.retrieve()
				.bodyToMono(R2dbcEmployee.class)
				.subscribe(this::logInfoEmployee)
		;
	}

	public void getById(final Integer id) {

		log.info("scheduled get by id...");

		getWebClient()
				.get()
				.uri(URI_ROOT + "/{id}", id)
				.retrieve()
				.bodyToMono(R2dbcEmployee.class)
				.subscribe(this::logInfoEmployee)
		;
	}

	public void getAll() {

		log.info("scheduled get all...");

		getWebClient()
				.get()
				.uri(URI_ROOT)
				.retrieve()
				.bodyToFlux(R2dbcEmployee.class)
				.subscribe(this::logInfoEmployee)
		;
	}

	private void logInfoEmployee(final R2dbcEmployee employee) {

		log.info(employee.toString());
	}

}
