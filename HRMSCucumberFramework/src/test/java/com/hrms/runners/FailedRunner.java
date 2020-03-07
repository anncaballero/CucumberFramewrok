package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed.txt"   //specifying feature path
		,glue="/com/hrms/steps"
		,monochrome=true
		, plugin="pretty"
		)

public class FailedRunner {

}
