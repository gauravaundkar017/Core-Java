package com.app.customers_utils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import com.app.core.Customer;
import com.app.core.ServicePlan;
//import com.app.custom_exception.CustomerException;
import com.app.custom_exception.CustomerException;

import static com.app.customers_utils.CutomersUtils.*;
public class CustomerValidations {
	public static void changePassword(String email, String oldPassword, String newPassword, List<Customer> listOfCustomers) throws CustomerException {
		Customer cust = logIn(email, oldPassword,listOfCustomers);
		cust.setPassword(newPassword);
	}
	public static String toRemoveCustomer(String email, List<Customer> listOfCustomers) throws CustomerException {
		int emailIndex = listOfCustomers.indexOf(new Customer(email));
		if (emailIndex == -1)
			throw new CustomerException("Invalid email.");
		return "Unsubscribe Successfully - " + listOfCustomers.remove(emailIndex).getFirstName();
	} 
	public static void toRemoveCustomerBornAfter(String dob, String sp,List<Customer> listOfCustomers) throws CustomerException {
		LocalDate date = validatedate(dob);
		Iterator<Customer> itr = listOfCustomers.iterator();
		ServicePlan plan = ServicePlan.valueOf(sp);
		while (itr.hasNext()) {
			Customer customer = itr.next();
			if(customer.getSp()==plan && customer.getDob().isAfter(date))
				itr.remove();
		}
		
	} 
	

}
