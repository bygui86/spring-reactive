package com.rabbit.samples.springreactiveweb.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@EnableWebFluxSecurity
// PLEASE NOTE: @Configuration already included in @EnableWebFluxSecurity
public class WebFluxSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public MapReactiveUserDetailsService mapReactiveUserDetailsService() {

		UserDetails userDetails = User
				.withUsername("admin")
				.password(passwordEncoder().encode("secret"))
				.roles("ADMIN")
				.build();

		return new MapReactiveUserDetailsService(userDetails);
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(final ServerHttpSecurity serverHttpSecurity) {

		return serverHttpSecurity
				.csrf().disable()

				.authorizeExchange()

				.pathMatchers(HttpMethod.PUT, "/employees").hasRole("ADMIN")
				.pathMatchers("/**").permitAll()

				.and().httpBasic()

				.and().build()
		;
	}
}
