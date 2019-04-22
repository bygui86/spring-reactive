package com.rabbit.samples.springreactiver2dbc.configs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.web.reactive.config.EnableWebFlux;

import javax.annotation.PostConstruct;
import java.util.Map;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@AllArgsConstructor
@Configuration
@EnableWebFlux
@Order(101)
public class WebFluxConfig {

	// DatabaseClient databaseClient;

	// TODO replace with ApplicationEvent listener
	@PostConstruct
	void postConstruct() {

		// log.info("drop employee table");
		//
		// databaseClient
		// 		.execute()
		// 		.sql("DROP TABLE IF EXISTS employee;")
		// 		.fetch()
		// 		.all()
		// 		.subscribe(this::logResults);
		//
		// log.info("create employee table");
		//
		// databaseClient
		// 		.execute()
		// 		.sql("CREATE TABLE IF NOT EXISTS employee (id varchar PRIMARY KEY, name varchar);")
		// 		.fetch()
		// 		.all()
		// 		.subscribe(this::logResults);
	}

	// public void logResults(final Map<String ,Object> results) {
	//
	// 	log.info("create sql table - results");
	// 	results.forEach(
	// 			(k, v) -> {
	// 				log.info("key {} value {} valueType {}", k, v.toString(), v.getClass());
	// 			}
	// 	);
	// }

}
