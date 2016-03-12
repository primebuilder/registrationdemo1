package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.common.base.Objects;

@Entity
public class Applicant {
	
	@javax.persistence.Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private long Id;
	
	@NotNull
	@Column(name = "name", nullable = false, updatable = false)
	private String name;
	
	@NotNull
	@Column(name = "email", nullable = false, updatable = false)
	private String email;

	@NotNull
	@Column(name = "topic", nullable = false, updatable = false)
	private String topic;
	
	@NotNull
	@Column(name = "year", updatable = false)
	private int year;
	
	Applicant(){}
	
	public Applicant(final String name,final String email, final String topic, final int year)
	{
		this.name=name;
		this.email=email;
		this.topic=topic;
		this.year=year;	
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString(){
		return Objects.toStringHelper(this).add("Id", Id).add("name", name).add("email", email).add("topic",topic).add("year",year).toString();
		
	}
}
