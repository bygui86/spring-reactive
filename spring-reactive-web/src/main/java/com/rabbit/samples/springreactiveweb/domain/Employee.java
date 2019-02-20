package com.rabbit.samples.springreactiveweb.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 19 Feb 2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

	String id;

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
