package com.rabbit.samples.springreactiver2dbc.configs;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.PROTOCOL;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 21 Feb 2019
 */
// @Configuration
// @EnableR2dbcRepositories("com.rabbit.samples.springreactiver2dbc.repos")
// @Profile("spi")
// public class SpiR2dbcConfig extends AbstractR2dbcConfiguration {
public class SpiR2dbcConfig {

	// TODO add custom properties to determine if h2 or postgres

	// @Bean
	// @Override
	// public ConnectionFactory connectionFactory() {
	//
	// 	return ConnectionFactories.get(
	// 			ConnectionFactoryOptions
	// 					.builder()
	// 					.option(DRIVER, "postgresql")
	// 					.option(HOST, "localhost")
	// 					// .option(PORT, 5432) // optional, defaults to 5432
	// 					.option(USER, "user")
	// 					.option(PASSWORD, "secret")
	// 					// .option(DATABASE, "reactive") // optional
	// 					.build()
	// 	);
	// }

}


