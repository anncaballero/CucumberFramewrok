package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {
	
	@FindBy(linkText="Leave")
	public WebElement leaveLnk;
	
	@FindBy(linkText="Leave List")
	public WebElement leaveList;
	
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']/b")
	public WebElement pimButn;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmployeeButn;
	
	public DashboardPageElements () {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}
	
	public void navigateToAddEmployee() {
		jsClick(pimButn);
		jsClick(addEmployeeButn);
	}
}

	