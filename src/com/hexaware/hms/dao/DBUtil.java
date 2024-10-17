 package com.hexaware.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() {
		Connection conn=null;
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","Eshwar@4646");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return conn;
	}

}
