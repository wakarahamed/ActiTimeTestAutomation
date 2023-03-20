package com.actitime.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="F:\\University of Sri JPura\\Semester 8\\ITS4202 Emerging_Technologies\\ActiTimeTestAutomation\\BDD_Demo\\src\\main\\java\\com\\actitime\\qa\\feature"
		
		,glue={"com/actitime/qa/stepdefinitions"}
		,monochrome = true,
				strict=true,
				dryRun=false
							
		)




public class TestRunner {
	
	
	

}
