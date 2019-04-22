package com.rabbit.samples.springreactiver2dbc;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.testcontainers.containers.PostgreSQLContainer;



/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 22 Apr 2019
 */
@Configuration
@EnableR2dbcRepositories
class InfrastructureConfiguration extends AbstractR2dbcConfiguration {

	private PostgreSQLContainer postgres = new PostgreSQLContainer();

	@Bean
	@Override
	public PostgresqlConnectionFactory connectionFactory() {

		postgres.start();

		PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder()
				.host(postgres.getContainerIpAddress())
				.port(postgres.getFirstMappedPort())
				.database(postgres.getDatabaseName())
				.username(postgres.getUsername())
				.password(postgres.getPassword())
				.build();

		return new PostgresqlConnectionFactory(config);
	}

	@PreDestroy
	void shutdown() {
		postgres.stop();
	}
}