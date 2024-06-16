package com.wikipedia.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
				 glue="com.wikipedia.stepDefinitions",
				 monochrome=true,
				 plugin= {"html:Reports/Regression/HTMLReports", "json:Reports/Regression/Cucumber.json","junit:Reports/Regression/Cucumber.xml"},
				 dryRun = false,
				 tags = ("@regression")
)
public class RegressionRunner {

}