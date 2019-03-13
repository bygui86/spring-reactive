package com.rabbit.samples.springreactiver2dbc.configs;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 05 Mar 2019
 */
@Slf4j
@Configuration
@Order(99)
@Profile("postgres")
public class R2dbcPostgresConfig extends AbstractR2dbcConfiguration {

	@Override
	public ConnectionFactory connectionFactory() {

		log.info("create r2dbc POSTGRES connection factory");

		final String msg = "Postgres DOCKER container started: IP '{}', port '{}', dbName '{}', user '{}', pw '{}'";
		final String containerIpAddress = "localhost";
		final int firstMappedPort = 5432;
		final String databaseName = "reactive";
		final String username = "user";
		final String password = "secret";

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
