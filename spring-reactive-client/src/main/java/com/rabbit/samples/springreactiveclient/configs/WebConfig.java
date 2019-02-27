package com.rabbit.samples.springreactiveclient.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 27 Feb 2019
 */
@Configuration
public class WebConfig {

	@Bean
	public WebClient webClient() {

		return WebClient.create("http://localhost:8080");
	}

}
