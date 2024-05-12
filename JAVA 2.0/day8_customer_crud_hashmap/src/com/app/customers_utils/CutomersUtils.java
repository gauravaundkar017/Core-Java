package com.app.customers_utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;
import com.app.custom_exception.CustomerException;

public class CutomersUtils {

	public static Customer validateCustomerDetails(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String plan, Map<String,Customer> listOfCustomers) throws CustomerException {
		if (!isValidEmail(email)) {
			throw new CustomerException(
					"---Email must contains special character and ends with .com or .org or .net---");
		}
		checkDuplicateEmail(email, listOfCustomers);
		passwordValidator(password);
		ServicePlan servicePlan = parseAndValidatePlanAndCharge(plan, regAmount);
		LocalDate date = parsingAndValidateAge(dob);
		return new Customer(firstName, lastName, email, password, regAmount, date, servicePlan);
	}
	
	
	public static LocalDate parsingAndValidateAge(String dob) throws CustomerException{
		LocalDate date = LocalDate.parse(dob);
		int age =  Period.between(date, LocalDate.now()).getYears();
		
		if(age < 21) {
			throw new CustomerException("Age is below 21");
		}
		return date;
	}
	
	

	public static void passwordValidator(String password) throws CustomerException {
		String regxString = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
			if(!password.matches(regxString)){
					throw new CustomerException("Weak password, please enter strong password");
			}
	}

	public static Customer logIn(String email, String password, Map<String,Customer> listOfCustomers)
			throws CustomerException {
		Customer cust = listOfCustomers.get(email);
		if (cust == null)
			throw new CustomerException("---Email is not Registered---");
		if (cust.getPassword().equals(password)) {
			return cust;
		}
		throw new CustomerException("Invalid Password");
	}

	public static ServicePlan parseAndValidatePlanAndCharge(String plan, double regAmount) throws CustomerException {
		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
		if (regAmount == servicePlan.getPalnPrice()) {
			return servicePlan;
		}
		throw new CustomerException("---Regester amount dosen't match with the chooser service plan---");

	}

	public static LocalDate validatedate(String dob) throws CustomerException {
		try {
			return LocalDate.parse(dob);
		} catch (Exception e) {
			throw new CustomerException("---Invalid Date :- Please Enter valid date---");
		}

	}

	public static boolean isValidEmail(String email) {
		return email.contains("@") && (email.endsWith(".com") || email.endsWith(".org") || email.endsWith(".net"));

	}

	public static void checkDuplicateEmail(String email, Map<String,Customer> listOfCustomers) throws CustomerException {

		if (listOfCustomers.containsKey(email))
			throw new CustomerException("---Duplicate Email---");
	}
	

}
