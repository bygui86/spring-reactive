package com.rabbit.samples.springreactiver2dbc.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

	@Id
	// String id;
	Long id;

	String name;

	@Override
	public String toString() {

		return new StringBuilder()
				.append("{\"id\":")
				.append(getId())
				.append(",\"name\":")
				.append(getName())
				.append("}")
				.toString();
	}

}
