package com.rabbit.samples.springreactiver2dbc.repos;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
// public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {

	// no-op
}
