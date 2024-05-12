package com.app.contact_tester;
import static com.app_contact_validation.ContactValidation.*;
import java.util.HashSet;
import java.util.Scanner;

import com.app.core.Contact;

public class ContactApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			HashSet<Contact> contacts = new HashSet<>();
			while (!exit) {
				System.out.println("Options : 1. Add Contacts and details  \n" 
						+ "2. Display All contacts \n" + "0. Exit ");
				System.out.println("Choose an option");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Add Contact and details ");
						System.out.println("Conatct_No    Name     Date    Email ");
						Contact c =  validateConatactDetails(sc.next(),sc.next(),sc.next(),sc.next(),contacts);
						contacts.add(c);
						break;

					case 2:
						System.out.println("Display customer details");
						for (Contact contact : contacts) {
							System.out.println(contact);
						}
						break;
					case 0:
						exit = true;
						break;

					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					sc.nextLine();
				}

			}

		}

	}

	

}
