package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods {
	
	@Given("I open browser and navigate to the HRMS")
	public void i_open_browser_and_navigate_to_the_HRMS() {
		//setUp();
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		login=new LoginPageElements();
	   sendText(login.username, "Admin");
	   sendText(login.password, "Syntax@123");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	    click(login.loginBtn);
	}

	@Then("I succesfully logged in")
	public void i_succesfully_logged_in() {
	    System.out.println("I am logged in");
	}
	
	@When("I enter valid username and invalid password")
	public void i_enter_validd_usernam_and_invalid_password() {
		login=new LoginPageElements();
		sendText(login.username, "Admin");
		sendText(login.password, "kwjdfnij");
		
	}

	@Then("I see error message")
	public void i_see_error_message() {
		boolean error=login.errorMsg.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}
	
	@Then("I close the browser")
	public void i_close_the_browser() {
		tearDown();
	}
	
	@When("I enter{string} and {string}")
	public void i_enter_and(String username, String password) throws InterruptedException {
		login=new LoginPageElements();
	    sendText(login.username, username);
	    sendText(login.password, password);
	}

	@Then("I see {string}")
	public void i_see(String errorMessage) {
		String errMsg=login.errorMsg.getText();
		Assert.assertEquals("Error messages did not match", errMsg, errorMessage);
	}



}
