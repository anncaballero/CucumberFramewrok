package com.hrms.steps;

import com.hrms.pages.PageInitializer;
import com.hrms.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonMethods {
	
	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting scenario"+scenario.getName());
		setUp();
		PageInitializer.initializeAllPage();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("End of scenario"+scenario.getName());
		if (scenario.isFailed()) {
			byte [] picture=takeScreenShot("/failed/"+scenario.getName());
			scenario.embed(picture, "image/png");
		}else {
			byte [] picture=takeScreenShot("/passed/"+scenario.getName());
			scenario.embed(picture, "image/png");
		}
		
		tearDown();
	}

}
