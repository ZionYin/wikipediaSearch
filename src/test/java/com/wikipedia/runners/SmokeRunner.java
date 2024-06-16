package com.wikipedia.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
				 glue="com.wikipedia.stepDefinitions",
				 monochrome=true,
				 plugin= {"html:Reports/Smoke/HTMLReports", "json:Reports/Smoke/Cucumber.json","junit:Reports/Smoke/Cucumber.xml"},
				 dryRun = false,
				 tags = ("@smoke")
)
public class SmokeRunner {

}