package com.app.customer_tester;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static com.app.customers_utils.CustomerValidations.*;
import static com.app.customers_utils.CutomersUtils.*;
import com.app.core.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<String, Customer> customers = new HashMap<>();
			while (!exit) {
				System.out.println("Options : 1. Create Customer Account \n"
						+ "2. Display All customers Accounts \n3. Sign in to portal "
						+ "\n4. Change Password \n5. Un subscribe\n6. Sort via email" 
						+ "\n7. sort dob n lname"
						+ "\n8. Remove all customer details from specified plan born after specified date.\n"
						+ "0. Exit ");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println();
						System.out.println("Enter below details : ");
						System.out.println("firstName, lastName, email, password, regAmount, date, servicePlan");
						Customer customerDetails = validateCustomerDetails(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customers);
						customers.put(customerDetails.getEmail(), customerDetails);
						System.out.println("Registration Done..");
						break;
					case 2:
						System.out.println("Display all Customers");
						customers.values().forEach(c->System.out.println(c));

						break;

					case 3:
						System.out.println("Login Page");
						System.out.println("Please Enter Details :- \nEmail    Password ");
						Customer signIn = logIn(sc.next(), sc.next(), customers);
						System.out.println(signIn);

						break;

					case 4:
						System.out.println("Change Password");
						System.out.println("Please Enter Details :- \nEmail    Old_Password     New_Password");
						changePassword(sc.next(), sc.next(), sc.next(), customers);

						break;
					case 5:
						System.out.print("Un-subscribe customer\nEnter your email : ");
						System.out.println(toRemoveCustomer(sc.next(),customers));
						break;
						
					case 6:
						System.out.println("Sort with email");
//						Collections.sort(customers);
						TreeMap<String, Customer> sortWithEmial = new TreeMap<>(customers);
						for (Customer c : sortWithEmial.values()) {
							System.out.println(c);
						}
						break;
			
						
//					case 7:
//						System.out.println("Sort with dobn lname");
//						Collections.sort(customers,new CustomerDobLNameComparator());
//						break;
					case 7:
						System.out.println("Sort with dob n lname");
						LinkedList<Customer> list = new LinkedList<Customer>(customers.values());
						Collections.sort(list,new Comparator<Customer>() {
							@Override
							public int compare(Customer c1, Customer c2) {
								int dobCompare = c1.getDob().compareTo(c2.getDob());
								if (dobCompare == 0) {
									return c1.getLastName().compareTo(c2.getLastName());
								}		
								return dobCompare;
							}
						});
						for (Customer c : list) {
							System.out.println(c);
						}
						break;
						
					case 8 :
						System.out.print("Enter date n plan: ");
						toRemoveCustomerBornAfter(sc.next(),sc.next(),customers);
						break;
					case 0:
						exit = true;
						break;

					default:
						break;
					}

				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}

			}

		}
		System.out.println("main over...");
	}

}