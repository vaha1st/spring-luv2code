package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcurl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";

		
		try {
			System.out.println("Connecting to database: "+jdbcurl);
			
			Connection connection = DriverManager.getConnection(jdbcurl, user, password);
			
			System.out.println("Connection successful!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
