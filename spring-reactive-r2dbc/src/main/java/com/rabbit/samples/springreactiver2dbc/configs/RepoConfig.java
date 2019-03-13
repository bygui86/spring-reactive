package com.rabbit.samples.springreactiver2dbc.configs;

import com.rabbit.samples.springreactiver2dbc.repos.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.function.ReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 07 Mar 2019
 */
@Slf4j
@AllArgsConstructor
@Configuration
@EnableR2dbcRepositories
@Order(100)
public class RepoConfig {

	DatabaseClient databaseClient;
	RelationalMappingContext relationalMappingContext;
	ReactiveDataAccessStrategy reactiveDataAccessStrategy;

	@Bean
	public EmployeeRepository employeeRepository() {

		return r2dbcRepositoryFactory().getRepository(EmployeeRepository.class);
	}

	@Bean
	public R2dbcRepositoryFactory r2dbcRepositoryFactory() {

		return new R2dbcRepositoryFactory(databaseClient, relationalMappingContext, reactiveDataAccessStrategy);
	}

}
