package com.app.tester;

import static com.app.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegesterNewCustomer {

	public static void main(String[] args) {
		// Register new customer
		//| id | first_name | last_name | email         
		//| password | dob        | status | role  |
		try (Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement ps = cn.prepareStatement("insert into users (id, first_name, last_name, email, password, dob, status, role) values(?,?,?,?,?,?,?,?)");

		) {
			System.out.println("id | first_name | last_name | email| password | dob | status | role  | ");
			ps.setInt(1, sc.nextInt());
			ps.setString(2,sc.next());
			ps.setString(3,sc.next());
			ps.setString(4,sc.next());
			ps.setString(5,sc.next());
			Date date1 = Date.valueOf(sc.next());
			ps.setDate(6, date1);
			ps.setBoolean(7,sc.nextBoolean());
			ps.setString(8,sc.next());
			
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected>0) {
				//ResultSet meth 
				System.out.println("Register Successfully!  ");
				
			}else {
				System.out.println("Not registered");
			}
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
