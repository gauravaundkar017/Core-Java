package com.app.tester;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//user login

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				// get db connection
				Connection cn = openConnection();
				// create pre-compiled stmt, to hold the sql
				PreparedStatement pst = cn.prepareStatement("select * from users where email=? and password=?");) {
			// execute select query n getResult

			System.out.println("Enter your email and password");
			// set in params : public void setType(int paramIndex, Type value ) throws
			// SQLException
			pst.setString(1, sc.next());// email
			pst.setString(2, sc.next());// passwd

			try (ResultSet rst = pst.executeQuery()) {
				if (rst.next()) {
					//ResultSet meth 
					System.out.println("Login Successful! Hello "+rst.getString("first_name")+" "+ rst.getString(3));
					System.out.println("User Details");
					System.out.printf("Id %d Name %s %s Email %s pwd %s DoB %s Satus %s" + " Role %s %n", rst.getInt(1),
							rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),
							rst.getBoolean(7), rst.getString(2));
				}else {
					System.out.println("Invalid login,  emial or password invalid");
				}

			}
		}


		catch (Exception e) {
			e.printStackTrace();
		}

	}

}