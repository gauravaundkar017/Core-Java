package com.app.tester;

import java.util.HashSet;
import java.util.Scanner;

import com.app.core.Contact;

public class ContactApp {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			HashSet<Contact> contact = new  HashSet<>();
			while(!exit) {
				System.out.println("Options: \n"+"1: Add contacts and Details \n " 
							+"2.Display all Details \n" +"3. Exit\n");
				
			}
			
		}
		
	}

}
