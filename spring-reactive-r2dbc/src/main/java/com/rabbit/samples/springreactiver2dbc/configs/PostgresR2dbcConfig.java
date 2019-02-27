package com.rabbit.samples.springreactiver2dbc.configs;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.annotation.PreDestroy;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 21 Feb 2019
 */
@Slf4j
@Configuration
@EnableR2dbcRepositories("com.rabbit.samples.springreactiver2dbc.repos")
// @Profile("postgres")
public class PostgresR2dbcConfig extends AbstractR2dbcConfiguration {

	private PostgreSQLContainer postgres = new PostgreSQLContainer();

	@Bean
	@Override
	public ConnectionFactory connectionFactory() {

		postgres.start();

		final String containerIpAddress = postgres.getContainerIpAddress();
		final Integer firstMappedPort = postgres.getFirstMappedPort();
		final String databaseName = postgres.getDatabaseName();
		final String username = postgres.getUsername();
		final String password = postgres.getPassword();

		log.info(
				"PostgreSQL docker container started: IP '{}', port '{}', dbName '{}', user '{}', pw '{}'",
				containerIpAddress,
				firstMappedPort,
				databaseName,
				username,
				password
		);

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

	@PreDestroy
	void shutdown() {

		postgres.stop();
	}

	// @Bean
	// @Override
	// public ConnectionFactory connectionFactory() {
	//
	// 	return new PostgresqlConnectionFactory(
	// 			PostgresqlConnectionConfiguration
	// 					.builder()
	// 					.host("localhost")
	// 					// .port(5432) // optional, defaults to 5432
	// 					.username("user")
	// 					.password("secret")
	// 					// .database("reactive") // optional
	// 					.build()
	// 	);
	// }

}
