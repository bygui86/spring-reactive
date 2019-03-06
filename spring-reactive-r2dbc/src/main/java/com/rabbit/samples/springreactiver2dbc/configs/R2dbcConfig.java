package com.rabbit.samples.springreactiver2dbc.configs;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 05 Mar 2019
 */
@Slf4j
@Configuration
@EnableR2dbcRepositories("com.rabbit.samples.springreactiver2dbc.repos")
@Order(99)
public class R2dbcConfig extends AbstractR2dbcConfiguration {

	// private PostgreSQLContainer postgres = new PostgreSQLContainer();

	// @PostConstruct
	// void postConstruct() {
	//
	// 	log.info("start postgres container...");
	//
	// 	postgres.start();
	// }
	//
	// @PreDestroy
	// void shutdown() {
	//
	// 	log.info("stop postgres container...");
	//
	// 	postgres.stop();
	// }

	@Override
	public ConnectionFactory connectionFactory() {

		log.info("create r2dbc connection factory");

		// Docker
		final String msg = "Postgres DOCKER container started: IP '{}', port '{}', dbName '{}', user '{}', pw '{}'";
		final String containerIpAddress = "localhost";
		final Integer firstMappedPort = 5432;
		final String databaseName = "reactive";
		final String username = "user";
		final String password = "secret";

		// TestContainer
		// final String msg = "Postgres TEST container started: IP '{}', port '{}', dbName '{}', user '{}', pw '{}'";
		// final String containerIpAddress = postgres.getContainerIpAddress();
		// final Integer firstMappedPort = postgres.getFirstMappedPort();
		// final String databaseName = postgres.getDatabaseName();
		// final String username = postgres.getUsername();
		// final String password = postgres.getPassword();

		log.info(msg, containerIpAddress, firstMappedPort, databaseName, username, password);

		return new PostgresqlConnectionFactory(
				PostgresqlConnectionConfiguration
						.builder()
						.host(containerIpAddress)
						.port(firstMappedPort)
						.database(databaseName)
						.username(username)
						.password(password)
						.build()
		);
	}

}
