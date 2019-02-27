package com.rabbit.samples.springreactiver2dbc.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Configuration
@EnableScheduling
@Profile("scheduling")
public class SchedulingConfig {

	// no-op
}
