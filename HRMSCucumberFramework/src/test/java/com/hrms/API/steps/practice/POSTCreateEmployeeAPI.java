package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCreateEmployeeAPI {

	private static RequestSpecification request;
	private Response response;
	public static Object employee_ID;

	@Given("user calls createEmployee API to verify that an emloyee was created")
	public void user_calls_createEmployee_API_to_verify_that_an_emloyee_was_created() {

		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);
		request.body(CommonMethods.readJson(APIConstants.CREATE_EMPLOYEE_JSON));

	}

	@When("User retrieves response for createEmployeeAPI")
	public void user_retrieves_response_for_createEmployeeAPI() {

		response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
		response.prettyPrint();

	}

	@Then("status code is {int} for createEmployeeAPI")
	public void status_code_is_for_createEmployeeAPI(int int1) {

		// assertion preferred, provided by Rest Assured
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates employee was created")
	public void user_validates_employee_was_created() {

		response.then().body("Message", equalTo("Entry Created"));

		response.then().body("Employee[0].emp_firstname", equalTo("Ejoel"));

		JsonPath jsonPathEvaluator = response.jsonPath();

		employee_ID = jsonPathEvaluator.get("Employee[0].employee_id");

		System.out.println("Employee ID is: " + employee_ID);

	}

}
