package com.wikipedia.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("I am at the advanced search page of Wikipedia")
	public void i_am_at_the_advanced_search_page_of_wikipedia() {
	    driver.get("https://en.wikipedia.org/w/index.php?search");
	}

	@When("I input a search term {string} in the search box")
	public void i_input_a_search_test_in_the_search_box(String term) {
	    driver.findElement(By.id("ooui-php-1")).sendKeys(term);
	}

	@And("I click the search button")
	public void i_click_the_search_button() {
	    driver.findElement(By.cssSelector("button.oo-ui-inputWidget-input")).click();

	}

	@Then("I should verify the status {string} of the search")
	public void i_should_verify_the_true_of_the_search(String status) {
	    boolean expectedStatus = Boolean.parseBoolean(status);
	    boolean actualStatus = driver.findElements(By.className("mw-search-exists")).size() > 0;
	    assertTrue(expectedStatus == actualStatus);
	}

}