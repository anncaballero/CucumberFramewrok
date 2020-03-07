package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

	}

	@Given("I navigated to the Add Employee Page")
	public void i_navigated_to_the_Add_Employee_Page() {
		dashboard.navigateToAddEmployee();

	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.saveBtn);
	}

	@Then("I see employee has been succesfully added")
	public void i_see_employee_has_been_succesfully_added() {
		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), empId);
	}

	@Then("I see employee with {string}, {string} and {string} is displayed")
	public void i_see_employee_with_and_is_displayed(String fName, String mName, String lName)
			throws InterruptedException {
		String empName;
		if (mName.isEmpty()) {
			empName = fName + " " + lName;
		} else {
			empName = fName + " " + mName + " " + lName;
		}

		Assert.assertEquals("Employee's full name is NOT being added", pdetails.nameOnPicture.getText(), empName);

	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {		
		
		List<Map<String, String>> empDetailList=empDetails.asMaps();
		
		for(Map<String, String> map:empDetailList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));

		}
	}

	@Then("I am able to modify Employee Details")
	public void i_am_able_to_modify_Employee_Details(DataTable modifyEmpDetail) throws InterruptedException {
		
List<Map<String, String>> modifyList=modifyEmpDetail.asMaps();
		
		for(Map<String, String> map: modifyList) {
			//click o edit
			click(pdetails.edit_saveBtn);
			
			//passing new details to the employee
			sendText(pdetails.driverLNumber, map.get("DriverLisence"));
			sendText(pdetails.calendarLisenceExpDate, map.get("ExpirationDate"));
			sendText(pdetails.ssn, map.get("SSN"));
			sendText(pdetails.sinNumber, map.get("SIN"));
			clickRadio(pdetails.gender, map.get("Gender"));
			Thread.sleep(5000);
			
			selectDdValue(pdetails.maritalStatus, map.get("MaritalStatus"));
			selectDdValue(pdetails.nationality, map.get("Nationality"));
			sendText(pdetails.dateOfBirth, map.get("DOB"));
			
			//click on save
			click(pdetails.edit_saveBtn);
		}

	}

}
