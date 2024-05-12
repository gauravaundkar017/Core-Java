package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class CustomerException extends Exception {
	public CustomerException(String mesg) {
		super(mesg);
	}
}
