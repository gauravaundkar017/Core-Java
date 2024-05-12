package com.app.utils;
 
import com.app.banking.BankAccount;
import com.app.custom_exceptions.BankingException;

public class BankingUtils {
//add static method to return ac details or thrw exc
	
	public static BankAccount findAccountDetailsByAccNo(int accNo, BankAccount[] accts) throws BankingException{
		
		// 1. create bank ac instance warapping pk
		BankAccount acct = new BankAccount(accNo);
		for (BankAccount a: accts) {
			if (a!=null && a.equals(acct)) {
				return a;
			}
		}
		throw new BankingException("Invalid a/c number !!!!");
		
	}
	
	
	
	
}
