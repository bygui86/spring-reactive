package com.rabbit.samples.springreactivewebsocket;

import com.rabbit.samples.springreactivewebsocket.clients.EmployeeWebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactiveWebSocketApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringReactiveWebSocketApplication.class, args);

		EmployeeWebSocketClient employeeWebSocketClient = new EmployeeWebSocketClient();
		employeeWebSocketClient.subscribeToFeeds();
	}

}
