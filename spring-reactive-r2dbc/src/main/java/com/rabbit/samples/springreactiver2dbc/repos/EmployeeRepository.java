package com.rabbit.samples.springreactiver2dbc.repos;

import com.rabbit.samples.springreactiver2dbc.domain.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {

	// no-op
}
