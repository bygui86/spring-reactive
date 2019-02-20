package com.rabbit.samples.springreactivemongo.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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
@Document("employees")
public class Employee {

	@Id
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
