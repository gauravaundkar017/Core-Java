package com.app.contactvalidation;

import java.time.LocalDate;
import java.util.HashSet;

import com.app.core.Contact;

public class ContactValidation {
	public static Contact validateContactDetails(String phNumber, String name, String dob,
			String email, HashSet<Contact> contact) {
		LocalDate date = LocalDate.parse(dob);
				return new Contact (phNumber, name, date,email);
		
	}

}
