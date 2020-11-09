package com.aimtech.parkingservlet.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lenoxproperty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idlenoxproperty;
	private String streetNumber;
	private String streetName;
	private String city;
	private String state;
	private String zipCode;
	
	public int getIdlenoxproperty() {
		return idlenoxproperty;
	}
	public void setIdlenoxproperty(int idlenoxproperty) {
		this.idlenoxproperty = idlenoxproperty;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
