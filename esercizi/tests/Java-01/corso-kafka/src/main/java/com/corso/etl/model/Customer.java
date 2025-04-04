package com.corso.etl.model;

import com.google.gson.Gson;

public class Customer extends ModelBase {
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	public Customer() {}
	
	public Customer(
		Integer id,
		String firstName,
		String lastName) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	
	public String toString() {
		return new Gson().toJson(this);
	}
}
