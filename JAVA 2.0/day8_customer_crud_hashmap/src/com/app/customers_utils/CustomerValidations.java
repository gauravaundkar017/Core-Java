package com.app.customers_utils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import com.app.core.Customer;
import com.app.core.ServicePlan;
//import com.app.custom_exception.CustomerException;
import com.app.custom_exception.CustomerException;

import static com.app.customers_utils.CutomersUtils.*;

public class CustomerValidations {
	public static void changePassword(String email, String oldPassword, String newPassword,
			Map<String, Customer> listOfCustomers) throws CustomerException {
		Customer cust = logIn(email, oldPassword, listOfCustomers);
		cust.setPassword(newPassword);
	}

	public static String toRemoveCustomer(String email, Map<String, Customer> listOfCustomers)
			throws CustomerException {
		Customer c = listOfCustomers.remove(email);
		if (c == null)
			throw new CustomerException("Invalid email.");
		return "Unsubscribe Successfully - " + c.getFirstName();
	}

//	public static void toRemoveCustomerBornAfter(String dob, String sp,Map<String,Customer> listOfCustomers) throws CustomerException {
//		LocalDate date = validatedate(dob);
//		LinkedList<Customer> list=new LinkedList<>(listOfCustomers.values());
//		Iterator<Customer> itr = list.iterator();
//		ServicePlan plan = ServicePlan.valueOf(sp.toUpperCase());
//		while (itr.hasNext()) {
//			Customer customer = itr.next();
//			if(customer.getSp()==plan && customer.getDob().isAfter(date))
//				itr.remove();
//		}
//		
//	} 
	public static void toRemoveCustomerBornAfter(String dob, String sp, Map<String, Customer> listOfCustomers)
			throws CustomerException {
		LocalDate date = validatedate(dob);
		ServicePlan plan = ServicePlan.valueOf(sp.toUpperCase());
		Iterator<Map.Entry<String, Customer>> itr = listOfCustomers.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Customer> entry = itr.next();
			Customer c = entry.getValue();
			if (c.getSp() == plan && c.getDob().isAfter(date)) {
				itr.remove();
			}
		}
	}
   
}