package com.aimtech.parkingservlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Occupant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idoccupant;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String emergencyContactFirstName;
	private String emergencyContactLastName;
	private String emergencyContactPhone;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isOwner;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isTenant;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isCurrent;

	@ManyToOne
	//@JoinColumn(name="lenoxproperty_idlenoxproperty",referencedColumnName="idlenoxproperty")
	private Lenoxproperty lenoxproperty;
	
	public int getIdoccupant() {
		return idoccupant;
	}

	public void setIdoccupant(int idoccupant) {
		this.idoccupant = idoccupant;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmergencyContactFirstName() {
		return emergencyContactFirstName;
	}

	public void setEmergencyContactFirstName(String emergencyContactFirstName) {
		this.emergencyContactFirstName = emergencyContactFirstName;
	}

	public String getEmergencyContactLastName() {
		return emergencyContactLastName;
	}

	public void setEmergencyContactLastName(String emergencyContactLastName) {
		this.emergencyContactLastName = emergencyContactLastName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public Lenoxproperty getLenoxproperty() {
		return lenoxproperty;
	}

	public void setLenoxproperty(Lenoxproperty lenoxproperty) {
		this.lenoxproperty = lenoxproperty;
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public boolean isTenant() {
		return isTenant;
	}

	public void setTenant(boolean isTenant) {
		this.isTenant = isTenant;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}

}
