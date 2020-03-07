package com.hrms.practice;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

public class Task {

	String dbUsername = "syntax_hrm";

	String dbPassword = "syntaxhrm123";

	// jdbc:type of driver:host:port/name of database
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	@Test
	public void getAllJobTitles() throws SQLException {
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=connection.createStatement();
		ResultSet rset=st.executeQuery("select * from ohrm_job_title");
		rset.next();
		
		String data;
		ArrayList <String> dataList=new ArrayList<String>();
		
		while(rset.next()) {
			dataList.add(rset.getObject("job_title").toString());
		}
		
		for(String jobTitles:dataList) {
			System.out.println(jobTitles);
		}
		
		rset.close();
		st.close();
		connection.close();
		
	}

}
