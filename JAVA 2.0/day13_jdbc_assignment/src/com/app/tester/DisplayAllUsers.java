package com.app.tester;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static com.app.utils.DBUtils.*;

public class DisplayAllUsers {

	public static void main(String[] args) {
		// 1. Display all users(not admin) details born between specified dates.

		try (Scanner sc = new Scanner(System.in);
				Connection cn = openConnection();
				PreparedStatement ps = cn.prepareStatement("select * from users where role != 'admin' and dob between ? and ?");

		) {
			System.out.println("Enter start date and end date : ");
			Date date1 = Date.valueOf(sc.next());
			Date date2 = Date.valueOf(sc.next());
			ps.setDate(1, date1);
			ps.setDate(2, date2);
			
			try(ResultSet rst = ps.executeQuery()){
				while(rst.next()) {
					System.out.printf("Id %d Name %s %s Email %s pwd %s DoB %s Satus %s" + " Role %s %n", rst.getInt(1),
							rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),
							rst.getBoolean(7), rst.getString(2));
				}
				
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}