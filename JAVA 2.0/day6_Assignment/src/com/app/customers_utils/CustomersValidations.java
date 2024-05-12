package com.app.customers_utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.custom_exceptions.CustomerException;

public class CustomersValidations {
	public static Customer validateAllInputOfCustomer(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String sp, List<Customer> listOfCustomer) throws CustomerException {
		if (!isValidEmail(email))
			throw new CustomerException("Email must contains special character and ends with .com or .org or .net");

		checkDuplicateEmail(email, listOfCustomer);
		LocalDate date = validateDate(dob);
		ServicePlan plan = parseAndValidatePlanAndCharger(sp, regAmount);
		return new Customer(firstName, lastName, email, password, regAmount, date, plan);
	}

	public static boolean isValidEmail(String email) {
		return email.contains("@") && (email.endsWith(".com") || email.endsWith(".org") || email.endsWith(".net"));
	}

	public static void checkDuplicateEmail(String email, List<Customer> listOfCustomer) throws CustomerException {
		Customer c = new Customer(email);
		if (listOfCustomer.contains(c)) {
			throw new CustomerException("Duplicate Account...");
		}

	}

	public static ServicePlan parseAndValidatePlanAndCharger(String plan, double regAmount) throws CustomerException {

		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());

		if (servicePlan.getPlanCost() == regAmount) {
			return servicePlan;
		}

		throw new CustomerException("Regester amount dosen't match with the chooser service plan");
	}

	public static LocalDate validateDate(String date) throws CustomerException {
		try {
			return LocalDate.parse(date);
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomerException("Invalid Date :- Please Enter valid date");
		}
	}

//	public static Customer logIn(String email, String password, List<Customer> listOfCustomer)
//			throws CustomerException {
//		for (Customer customer : listOfCustomer) {
//			if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
//				return customer;
//			}
//		}
//		throw new CustomerException("Invalid Credentials");
//	}

	public static Customer logIn(String email, String password, List<Customer> listOfCustomer)
			throws CustomerException {
		//1.Index of
		//2.Invalid Email:throw custom exception
		//3.get -- Customer ref --ck pwd --invalid--throw cust exc
		//
		
		int emailIndex = -1;//invalid email 
		int passwordIndex = -1;//invalid password throw custom exc
		for (Customer cust : listOfCustomer) {
			if (cust.getEmail().equals(email)) {
				emailIndex = listOfCustomer.indexOf(cust);//cust ref holding pk
			}
			if (cust.getPassword().equals(password)) {
				passwordIndex = listOfCustomer.indexOf(cust);
			}
		}
		if (emailIndex == -1)
			throw new CustomerException("Invalid Email ");
		if (passwordIndex == -1)
			throw new CustomerException("Invalid Password");

		if (emailIndex == passwordIndex) {
			Customer cst = listOfCustomer.get(emailIndex);
			if (cst.getPassword().equals(password)) {
				return cst;
			}
		}
		throw new CustomerException("Invalid Credentials");

	}

	/*public static Customer login(String email, String password, List<Customer> listCustomer )
		throws CustomerException{
		//1.public int indexOf(Object o)
		//create cust instance 
		Customer newCust = new Customer(email);//pk
		int index = listCustomer.indexOf(newCust);//O(n)
		//2. invalid email; throw cust exc
		if(index == -1)
			throw new CustomerException("Invalid Email, Login Failed");
		Customer customer = listCustomer.get(index);//O(1)
		
		if(customer.getPassword().equals(password))
			return customer;
				throw new CustomerException("Invalid Password");
		
	}*/

	public static void changePassword(String email,String oldPassword, String newPassword,List<Customer> listOfCustomers) throws CustomerException {
		Customer c = logIn(email,oldPassword,listOfCustomers);
		if (c != null) {
			c.setPassword(newPassword);
			System.out.println("Password updated successfully..");
		}else {
			throw new CustomerException("Invalid email or password");
		}

	}

	/*public static void changePassword(String email, String newPassword, List<Customer> listOfCustomers)
			throws CustomerException {
		int index = listOfCustomers.indexOf(new Customer(email));
		if (index == -1)
			throw new CustomerException("Invalid email.");
		Customer c = listOfCustomers.get(index);
		c.setPassword(newPassword);
		System.out.println("Password updated successfully..");
	}
*/
	/*
	public static void changePassword(String email, String newPassword, List<Customer> list) throws CustomerException{
		Customer customer = new Customer(email);
		int index = list.indexOf(customer);
		if(index == -1)
			throw new CustomerException("Invalid Email!!!");
		Customer cindex = list.get(index);
		cindex.setPassword(newPassword);
		System.out.println("Pass successfully changed");
	
	}*/
	public static String toRemoveCustomer(String email, List<Customer> listOfCustomers) throws CustomerException {
		int emailIndex = listOfCustomers.indexOf(new Customer(email));
		if (emailIndex == -1)
			throw new CustomerException("Invalid email.");
		return "Unsubscribe Successfully - " + listOfCustomers.remove(emailIndex);
	}

	// gaurv a email@.com pass 2000 2011-11-11 gold

	public static LocalDate parseDateValidateDate(String dob) throws CustomerException{
		LocalDate birthDate = LocalDate.parse(dob);
		int age = Period.between(birthDate, LocalDate.now()).getYears();
		if(age >= 21)
			return birthDate;
		throw new CustomerException("Age is not Valid");
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
