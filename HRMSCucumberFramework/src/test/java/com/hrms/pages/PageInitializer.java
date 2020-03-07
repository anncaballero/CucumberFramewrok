package com.hrms.pages;

import com.hrms.testbase.BaseClass;

public class PageInitializer extends BaseClass {
	
	protected static LoginPageElements login;
	protected static DashboardPageElements dashboard;
	protected static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements pdetails;
	
	public static void initializeAllPage() {
		login=new LoginPageElements();
		dashboard=new DashboardPageElements();
		addEmp=new AddEmployeePageElements();
		pdetails=new PersonalDetailsPageElements();
	}

}
