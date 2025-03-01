package com.app.core;

import java.time.LocalDate;

public class Contact {
	private String phoneNumber;
	private String name;
	private LocalDate dob;
	private String email;

	@Override
	public String toString() {
		return "Contact [phoneNumber=" + phoneNumber + ", name=" + name + ", dob=" + dob + ", email=" + email + "]";
	}

	public Contact(String phoneNumber, String name, LocalDate dob, String email) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	public Contact(String name, LocalDate dob) {
		this.name = name;
		this.dob = dob;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		System.out.println("Equals");
		if (o instanceof Contact) {
			Contact c = (Contact) o;
			return this.name.equals(c.name) && this.dob.equals(c.dob);
		}	
		return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("HashCode");
		return name.hashCode() + dob.hashCode();
	}
	
	
	
	
}
