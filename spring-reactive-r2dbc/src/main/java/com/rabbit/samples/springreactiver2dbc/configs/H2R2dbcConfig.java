package com.rabbit.samples.springreactiver2dbc.configs;

// import io.r2dbc.h2.H2ConnectionConfiguration;
// import io.r2dbc.h2.H2ConnectionFactory;
// import io.r2dbc.spi.ConnectionFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
// import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 21 Feb 2019
 */
// @Configuration
// @EnableR2dbcRepositories("com.rabbit.samples.springreactiver2dbc.repos")
// @Profile("h2")
// public class H2R2dbcConfig extends AbstractR2dbcConfiguration {
public class H2R2dbcConfig {

	// @Bean
	// @Override
	// public ConnectionFactory connectionFactory() {
	//
	// 	return new H2ConnectionFactory(
	// 			H2ConnectionConfiguration
	// 					.builder()
	// 					.inMemory("reactive")
	// 					.build()
	// 	);
	// }

}
