package com.rabbit.samples.springreactivefunc;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.repos.EmployeeRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = SpringReactiveFuncApplication.class
)
public class EmployeeUnitTest {

	@Autowired
	WebTestClient webTestClient;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void test_getAll() {

		// given
		Employee employee1 = new Employee("1", "Employee 1");
		Employee employee2 = new Employee("2", "Employee 2");
		Employee employee3 = new Employee("3", "Employee 3");

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);

		given(employeeRepository.findAll())
				.willReturn(Flux.fromIterable(employeeList));

		webTestClient
				// when
				.get()
				.uri("/employees")
				.exchange()

				// then
				.expectStatus()
				.isOk()
				.expectBodyList(Employee.class)
				.isEqualTo(employeeList);

		// verify
		verify(employeeRepository).findAll();
	}

	@Test
	public void test_getById() {

		// given
		final String employeeId = "1";
		Employee employee = new Employee(employeeId, "Employee 1");
		given(employeeRepository.findById(employeeId))
				.willReturn(Mono.just(employee));

		webTestClient
				// when
				.get()
				.uri("/employees/" + employeeId)
				.exchange()

				// then
				.expectStatus()
				.isOk()
				.expectBody(Employee.class)
				.isEqualTo(employee);

		// verify
		verify(employeeRepository).findById(employeeId);
	}

	@Test
	public void test_update() {

		// given
		Employee employee = new Employee("1", "Employee 1 Updated");
		given(employeeRepository.update(employee))
				.willReturn(Mono.just(employee));

		webTestClient
				// when
				.put()
				.uri("/employees")
				.body(Mono.just(employee), Employee.class)
				.exchange()

				// then
				.expectStatus()
				.isOk()
				.expectBody(Employee.class)
				.isEqualTo(employee);

		// verify
		verify(employeeRepository).update(employee);
	}


}
