package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;

import gherkin.deps.com.google.gson.JsonObject;

public class SampleAPITest {
	
	//@Test
	public void getAllJobTitles() {
		
		Response response = RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5NCwidXNlcklkIjoiOTAifQ.6DN8HpqE0aPhvbvZygdM80csQp4QZdQBvQveVxmkCLw")
		.when().get("http://18.232.148.34/syntaxapi/api/jobTitle.php");
		
		response.prettyPrint();
		int actualResponseConde=response.getStatusCode();
		System.out.println(actualResponseConde);
	}
	
	//@Test
	public void getOneEmployee() {
		
		Response response=RestAssured.given().param("employee_id", "3447").contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5NCwidXNlcklkIjoiOTAifQ.6DN8HpqE0aPhvbvZygdM80csQp4QZdQBvQveVxmkCLw")
		.when().get("http://18.232.148.34/syntaxapi/api/getOneEmployee.php");
		
		response.prettyPrint();
		
	}
	
	/*
	 * TASK:  getAllEmployeeStatuses
	 * pretty print
	 * print status code
	 * 
	 */
	
	//@Test
	public void getAllEmployeeStatuses() {
		
		Response response=RestAssured.given().contentType("application/json").header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5NCwidXNlcklkIjoiOTAifQ.6DN8HpqE0aPhvbvZygdM80csQp4QZdQBvQveVxmkCLw")
		.when().get("http://18.232.148.34/syntaxapi/api/employeeStatus.php");
		
		response.prettyPrint();
		int statusCode=response.getStatusCode();
		
		System.out.println(statusCode);
		
	}
	
	@Test
	public void createEmployee() {
		
		Response response=RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3OTQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk5NCwidXNlcklkIjoiOTAifQ.6DN8HpqE0aPhvbvZygdM80csQp4QZdQBvQveVxmkCLw")
		.body("{\n    \"emp_firstname\": \"Kalissss\",\n    \"emp_lastname\": \"Bresada\",\n    \"Y\": \"Senior\",\n    \"emp_gender\": \"1\",\n    \"emp_birthday\": \"1965-02-23\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}")
		.post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
//				.param("emp_firstname", "Hello")
//		.param("emp_lastname", "Student")
//		.param("emp_middle_name", "Syntax")
//		.param("emp_gender", "1")
//		.param("emp_birthday", "1991-02-02")
//		.param("emp_status", "Employee")
//		.param("emp_job_title", "Cloud Architect")
		
		
		response.prettyPrint();
		int actualStatusCode=response.getStatusCode();
		Assert.assertEquals(200, actualStatusCode);
		
	}
	

}
