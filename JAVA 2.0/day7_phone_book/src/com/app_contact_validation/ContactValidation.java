package com.app_contact_validation;

import java.time.LocalDate;
import java.util.HashSet;

import com.app.core.Contact;
import com.app.custom_exception.CustomException;

public class ContactValidation {

	public static Contact validateConatactDetails(String phoneNumber, String name, String dob, String email,
			HashSet<Contact> contacts) throws CustomException {
		LocalDate date = LocalDate.parse(dob);
//		NoDupNameAndDob(name,dob,contacts);
		Contact newCon = new Contact(phoneNumber, name, date, email);
		addContact(newCon, contacts);
		return newCon;

	}

	public static void addContact(Contact contact, HashSet<Contact> contacts) throws CustomException {
		if (contacts.contains(contact)) {
			throw new CustomException("Contact with the same name and date of birth already exists in the phone book.");
		}
	}

//	  public static void NoDupNameAndDob(String name, String dob, HashSet<Contact> contacts) throws CustomException {
//			LocalDate date = LocalDate.parse(dob);
//			Contact c = new Contact(name, date);
//				if (contacts.contains(c)) {
//					throw new CustomException("---Duplicate Name and Date of Birth---");
//				}
//		}
}