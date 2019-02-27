package com.rabbit.samples.springreactivewebsocket.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


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
@EqualsAndHashCode
@ToString
public class Event {

	String id;

	String time;

}
