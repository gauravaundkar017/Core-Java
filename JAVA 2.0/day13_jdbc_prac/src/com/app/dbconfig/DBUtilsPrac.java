package com.app.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilsPrac {
	public static Connection connection;
	private static final String DB_URL;
	private static final String USER_NAME;
	private static final String PASSWORD;
	static {
		DB_URL = "jdbc:mysql://localhost:3306/iacsd_jdbc_mar24";
		USER_NAME = "root";
		PASSWORD = "123";
	}
	public static Connection openConnection() throws SQLException {
		connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		return connection;
	}

}
