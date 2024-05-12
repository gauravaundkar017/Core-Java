package com.app.utils;

import java.time.LocalDate;

import com.app.banking.AcType;
import com.app.banking.BankAccount;
import com.app.custom_exceptions.BankingException;

public class BankingValidations {
	public static final double MIN_BALANCE;
	static {
		MIN_BALANCE = 5000;
	}

//add public static method to validate for min bal
	public static void validateBalance(double balance) throws BankingException {
		if (balance < MIN_BALANCE)
			throw new BankingException("Insufficient Balance !!!!!");
		System.out.println("valid balance....");
	}

//add public staic method to validate all ips
	public static BankAccount validateInputs(int acctNo, String firstName, String lastName, String acType, String dob,
			String creationDate, double balance) throws BankingException 
	{
		AcType type = AcType.valueOf(acType.toUpperCase());
		LocalDate birthDate = LocalDate.parse(dob);
		LocalDate ceDate = LocalDate.parse(creationDate);
		validateBalance(balance);
		
		return new BankAccount(acctNo, firstName, lastName, type, birthDate, ceDate, balance);
	}
}
