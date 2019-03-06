package com.rabbit.samples.springreactivefunc;

import com.rabbit.samples.springreactivefunc.domain.Employee;
import com.rabbit.samples.springreactivefunc.repos.impl.StaticEmployeeRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockUser;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.springSecurity;


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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeManualFunctionalTest {

	@Autowired
	ApplicationContext applicationContext;

	WebTestClient webTestClient;

	@Before
	public void setup() {

		// reset in-memory employees map
		final StaticEmployeeRepository staticEmployeeRepository = applicationContext.getBean(StaticEmployeeRepository.class);
		staticEmployeeRepository.initData();

		webTestClient = WebTestClient
				.bindToApplicationContext(applicationContext)
				// add Spring Security test Support
				.apply(springSecurity())
				// .filter(basicAuthentication("user", "secret"))
				.build();
	}

	@Test
	public void test_getAll() {

		// given
		Employee employee1 = new Employee("1", "Employee 1");
		Employee employee2 = new Employee("2", "Employee 2");
		Employee employee3 = new Employee("3", "Employee 3");

		webTestClient
				// when
				.get()
				.uri("/employees")
				.exchange()

				// then
				.expectStatus()
				.isOk()
				.expectBodyList(Employee.class)
				.hasSize(10)
				.contains(employee1)
				.contains(employee2)
				.contains(employee3);
	}

	@Test
	public void test_getById() {

		// given
		Employee employee = new Employee("1", "Employee 1");

		webTestClient
				// when
				.get()
				.uri("/employees/1")
				.exchange()

				// then
				.expectStatus()
				.isOk()
				.expectBody(Employee.class)
				.isEqualTo(employee);
	}

	@Test
	public void test_update() {

		// given
		Employee employee = new Employee("1", "Employee 1 Updated");

		webTestClient
				.mutateWith(mockUser().roles("ADMIN"))
				// when
				.put()
				.uri("/employees")
				.body(Mono.just(employee), Employee.class)
				.exchange()

				//then
				.expectStatus()
				.isOk()
				.expectBody(Employee.class)
				.isEqualTo(employee);
	}

}
