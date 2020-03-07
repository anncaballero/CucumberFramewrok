package com.hrms.practice;

import java.sql.*;

import org.junit.Test;

public class JdbcDemo {
	
	String dbUsername= "syntax_hrm";
	
	String dbPassword="syntaxhrm123";
	
	//jdbc:type of driver:host:port/name of database 
	String dbUrl="jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	@Test
	public void getDataFromDatabase() throws SQLException {
		
		//1. Building connection
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		System.out.println("Connection is created");
		
		//2. Build statement object
		Statement st=connection.createStatement();
		
		//3. Execute query + get an object of the ResultSet
		ResultSet rset=st.executeQuery("select * from ohrm_nationality");
		
		//4. Moves curser to the next row (skipping header)
		rset.next();
		
		// retrieving 1 String value
		String firstRowData=rset.getString("name");
		System.out.println(firstRowData);
		
		// retrieving data as an object then converting it to String
		rset.next();
		String secondRowData=rset.getObject("name").toString();
		System.out.println(secondRowData);
		
		//Looping through all the Nationality Data
		String data;
		while(rset.next()) {
			data=rset.getObject("name").toString();
			System.out.println(data);
		}
		
		// closing all the connections
		rset.close();
		st.close();
		connection.close();
		
	}

}
