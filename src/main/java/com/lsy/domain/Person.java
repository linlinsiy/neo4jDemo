package com.lsy.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Person {

	@GraphId
	private Long id;

	private String name;

	@Relationship(type = "KNOWS",direction = Relationship.OUTGOING)
	private Set<Person> friends = new HashSet<>();

//	@Relationship(type = "ACTED_IN")
//	private List<Person> friends = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Person> getFriends() {
		return friends;
	}

	public void setFriends(Set<Person> friends) {
		this.friends = friends;
	}

	public void knowsSomeone(Person person){
		friends.add(person);
	}
	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
