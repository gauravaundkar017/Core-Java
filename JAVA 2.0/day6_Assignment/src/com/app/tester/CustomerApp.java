package com.app.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.app.customers_utils.CustomersValidations.*;
import com.app.core.Customer;

public class CustomerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			List<Customer> customers = new ArrayList<>();
			while (!exit) {
				System.out.println("Options : 1. Create Customer Account \n" + "2. Display All customers Accounts \n3. Sign in to portal \n4. Change Password \n5. Un subscribe\n"
						+ "0. Exit ");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println();
						System.out.println("Enter customer details -" + 
						"firstName, lastName, email, password, regAmount, date, plan");
						Customer validateAllInputOfCustomer = validateAllInputOfCustomer(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(), customers);
						customers.add(validateAllInputOfCustomer);
						System.out.println("Customer Account created");
						break;
					case 2:
						System.out.println("All account details -");
						for (Customer c : customers) {
							System.out.println(c);
						}
						break;
						
						
					case 3 :
						System.out.println("Login Page");
						System.out.println("Please Enter Details :- \nEmail    Password ");
						Customer signIn = logIn(sc.next(),sc.next(),customers);
						System.out.println(signIn);
						break;
					
					case 4 :
						System.out.println("Change Password");
//						System.out.println("Please Enter Details :- \nEmail    Old_Password     New_Password");
//						changePassword(sc.next(),sc.next(),sc.next(),customers);
						System.out.println("Please Enter Details :- \nEmail  New_Password");
						changePassword(sc.next(),sc.next(),sc.next(),customers);
						break;
						
					case 5:
						System.out.println("Un subscribe customer");
						System.out.println(toRemoveCustomer(sc.next(),customers));
						break;
					
					case 0:
						exit = true; 
						
						break;
					default:
						break;
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					sc.nextLine();
				}

			}

		}
		System.out.println("main over...");


	}

}
