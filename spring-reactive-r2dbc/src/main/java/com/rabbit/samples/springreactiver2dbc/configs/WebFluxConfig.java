package com.rabbit.samples.springreactiver2dbc.configs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.web.reactive.config.EnableWebFlux;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@AllArgsConstructor
@Configuration
@EnableWebFlux
@Order(100)
public class WebFluxConfig {

	DatabaseClient databaseClient;

	@PostConstruct
	void postConstruct() {

		log.info("create postgres table");

		List<String> statements =
				Arrays.asList(
						"DROP TABLE IF EXISTS employee;",
						"CREATE TABLE employee ( id SERIAL PRIMARY KEY, name VARCHAR(250) );"
				);

		statements.forEach(
				state -> databaseClient
						.execute()
						.sql(state)
						.fetch()
						// .rowsUpdated()
						.all()
		);
	}

}
