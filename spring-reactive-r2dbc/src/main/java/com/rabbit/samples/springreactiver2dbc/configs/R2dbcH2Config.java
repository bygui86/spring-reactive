package com.rabbit.samples.springreactiver2dbc.configs;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
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
@Profile("h2")
public class R2dbcH2Config extends AbstractR2dbcConfiguration {

	@Override
	public ConnectionFactory connectionFactory() {

		log.info("create r2dbc H2 connection factory");

		return new H2ConnectionFactory(
				H2ConnectionConfiguration
						.builder()
						.inMemory("reactive")
						.build()
		);
	}

}
