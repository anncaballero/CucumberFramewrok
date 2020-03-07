package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy(id = "empPic")
	public WebElement empPicture;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;

	@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
	public WebElement empId;

	@FindBy(id = "btnSave")
	public WebElement edit_saveBtn;

	@FindBy(xpath = "//input[@name='personal[optGender]']")
	public List<WebElement> gender;

	@FindBy(xpath = "//input[@id='personal_txtLicenNo']")
	public WebElement driverLNumber;

	@FindBy(css = "input[id='personal_txtLicExpDate']")
	public WebElement calendarLisenceExpDate;

	@FindBy(css = "input[id='personal_txtNICNo']")
	public WebElement ssn;

	@FindBy(css = "select[id='personal_cmbMarital']")
	public WebElement maritalStatus;

	@FindBy(css = "select[id='personal_cmbNation']")
	public WebElement nationality;

	@FindBy(css = "input[id='personal_DOB']")
	public WebElement dateOfBirth;

	@FindBy(css = "input[id='personal_txtEmpNickName']")
	public WebElement nickName;

	@FindBy(css = "input[id='personal_txtMilitarySer']")
	public WebElement militaryService;

	@FindBy(css = "input[id='personal_chkSmokeFlag']")
	public WebElement smokerChckB;

	@FindBy(css = "input#personal_txtSINNo")
	public WebElement sinNumber;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
