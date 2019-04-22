package com.rabbit.samples.springreactiver2dbc.configs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 07 Mar 2019
 */
@Slf4j
@AllArgsConstructor
@Configuration
@EnableR2dbcRepositories(
		basePackages = "com.rabbit.samples.springreactiver2dbc.repos"
)
@Order(100)
public class RepoConfig {

	// no-op
}
