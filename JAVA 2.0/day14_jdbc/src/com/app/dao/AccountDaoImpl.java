package com.app.dao;

import java.sql.*;
import static com.app.utils.DBUtils.*;

public class AccountDaoImpl implements AccountDao {
	
	//state 
	private Connection cn;
	private CallableStatement cst1,cst2;
	
	//def ctor
	public AccountDaoImpl() throws SQLException {
		//get db connection
		cn = openConnection();
		//create cst to invoke stored proc
		cst1= cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		//regester out params
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		
		cst2= cn.prepareCall("{ ? = call transfer_funds_func(?,?,?) }");
		cst2.registerOutParameter(1, Types.DOUBLE);
		System.out.println("Acct dao created...");
		
	}
	
	@Override
	public String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		//1. set IN params
		cst1.setInt(1, srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		
		//2. excecute procedure 
		cst1.execute();
		return "Updated source balance " + cst1.getDouble(4) + " Updated destination balance " + cst1.getDouble(5 );
	}
	
	public String transferFundsFunc(int srcAcNo, int destAcNo, double amount) throws SQLException {
		cst2.setInt(2, srcAcNo);
		cst2.setInt(3, destAcNo);
		cst2.setDouble(4, amount);
		
		//2. excecute procedure 
		cst2.execute();
		return "Updated source balance " + cst2.getDouble(1)/* + cst1.getDouble(1) + " Updated destination balance " + cst1.getDouble(2) */;
		
	}
	
	public void cleanUp() throws SQLException {
		System.out.println("acct dao cleanup");
		if(cst1 != null)
			cst1.close();
		if(cst2 != null)
			cst2.close();
		closeConnection();
	}

}