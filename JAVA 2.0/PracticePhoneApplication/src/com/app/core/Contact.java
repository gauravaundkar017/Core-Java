package com.app.core;

import java.time.LocalDate;

public class Contact {
	private String phNumber;
	private String name;
	private LocalDate dob;
	private String email;
	
	
	public Contact(String phnumber, String name, LocalDate dob, String email) {
		this.phNumber=phNumber;
		this.name=name;
		this.dob=dob;
		this.email=email;
		
	}
	public String toString() {
		return "Phone number: " + phNumber + "Name: "+ name + "Date of Birth: "+dob + "EmailId: "+email;
	}
}
