package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable{
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;

	private static int count;

	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		count++;
		this.customerId = count;
	}

//	public Customer(String email) {
//		// TODO Auto-generated constructor stub
//		this.email = email;
//	}
	
//	@Override
//	public int compareTo(Customer c) {
//		return this.email.compareTo(c.email);
//	}

//	@Override
//	public boolean equals(Object o) {
//		System.out.println("In customers equals");
//		if (o instanceof Customer) {
//			Customer anotherCustomer = (Customer) o;
//			return this.email.equals(anotherCustomer.email);
//		}
//		return false;
//
//	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", RegestrationAmount=" + regAmount + ", dob=" + dob + ", Service Plan=" + plan + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}



	public LocalDate getDob() {
		return dob;
	}

	public ServicePlan getSp() {
		// TODO Auto-generated method stub
		return plan;
	}

	

}
