package com.app.core;

import java.time.LocalDate;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob; 
	private ServicePlan sp;
	
	private static int count;

	public Customer( String firstName, String lastName, String email, String password, double regAmount,
			LocalDate dob, ServicePlan sp) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.sp = sp;
		count++;
		this.customerId = count ;
	}

	public Customer(String email) {
		// TODO Auto-generated constructor stub
		this.email=email;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", RegestrationAmount=" + regAmount + ", dob=" + dob + ", Service Plan=" + sp + "]";
	}


	public static int getCount() {
		return count;
	}
	@Override
	public boolean equals(Object o) {
		System.out.println("In customers equals");
		if(o instanceof Customer) {
			Customer c = (Customer)o;
			return this.email.equals(c.email);
		}
		return false; 
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	



}
