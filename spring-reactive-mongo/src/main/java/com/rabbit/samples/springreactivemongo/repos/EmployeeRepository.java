package com.rabbit.samples.springreactivemongo.repos;

import com.rabbit.samples.springreactivemongo.domain.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

	// no-op
}
