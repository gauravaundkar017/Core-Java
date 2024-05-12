package com.app.dao;

import java.sql.SQLException;

public interface AccountDao {
	//add a method for invoking a stored proc from DB , to transfer full
	
	String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException;
	String transferFundsFunc(int srcAcNo, int destAcNo, double amount) throws SQLException;

}
