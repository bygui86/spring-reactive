package com.rabbit.samples.springreactiver2dbc;

import com.rabbit.samples.springreactiver2dbc.clients.EmployeeWebClient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(AccessLevel.PROTECTED)
@SpringBootApplication
public class SpringReactiveR2dbcApplication {

	public static void main(String[] args) throws InterruptedException {

		final ConfigurableApplicationContext context = SpringApplication.run(SpringReactiveR2dbcApplication.class, args);

		EmployeeWebClient employeeWebClient = context.getBean(EmployeeWebClient.class);

		employeeWebClient.initDb();

		Thread.sleep(3000);

		employeeWebClient.insert();
		employeeWebClient.insert();
		employeeWebClient.insert();

		Thread.sleep(3000);

		employeeWebClient.getAll();

		Thread.sleep(3000);

		employeeWebClient.getById();
	}

}
