package com.aimtech.parkingservlet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {
	
	@Id
	private int idtest;
	private String firstname;
	private String lastname;
	
	public int getIdtest() {
		return idtest;
	}
	public void setIdtest(int idtest) {
		this.idtest = idtest;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
