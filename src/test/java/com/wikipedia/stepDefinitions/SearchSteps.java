package com.wikipedia.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wikipedia.pages.WikipediaSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	private WebDriver driver;
	private WikipediaSearchPage searchPage;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		searchPage = new WikipediaSearchPage(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("I am at the advanced search page of Wikipedia")
	public void i_am_at_the_advanced_search_page_of_wikipedia() {
		searchPage.goToSearchPage();
	}

	@When("I input a search term {string} in the search box")
	public void i_input_a_search_test_in_the_search_box(String term) {
		searchPage.inputSearchTerm(term);
	}

	@And("I click the search button")
	public void i_click_the_search_button() {
		searchPage.clickSearchButton();

	}

	@Then("I should verify the status {string} of the search")
	public void i_should_verify_the_true_of_the_search(String status) {
		boolean expectedStatus = Boolean.parseBoolean(status);
		boolean actualStatus = searchPage.hasSearchResult();
		assertTrue(expectedStatus == actualStatus);
	}

	// Search suggestions test steps

	@When("I click the search box for suggestions to pop up")
	public void i_click_the_search_box_for_suggestions_to_pop_up() {
		searchPage.clickSearchBox();
	}

	@Then("Search suggestions should be displayed")
	public void search_suggestions_should_be_displayed() {
		searchPage.waitForOneSecond();
		assertTrue(searchPage.hasSearchSuggestion());
	}

	@Then("Suggestions should contain suggestion {string}")
	public void suggestions_should_include(String suggestion) {
		assertTrue(searchPage.containSuggestion(suggestion));
	}

	@Then("No search suggestions should be displayed")
	public void no_search_suggestions_should_be_displayed() {
		searchPage.waitForOneSecond();
		assertTrue(!searchPage.hasSearchSuggestion());
	}

	// search paging steps below
	
	@When("I click on the next page button")
	public void i_click_on_the_next_page_button() {
		searchPage.clickNextButton();
	}

	@When("I click on the previous page button")
	public void i_click_on_the_previous_page_button() {
		searchPage.clickPreviousButton();
	}

	@Then("I should be on page {int}")
	public void i_should_be_on_page(Integer pageNum) {
		assertTrue(searchPage.isOnPage(pageNum));
	}

	@Then("I verify the content on page")
	public void i_verify_the_content_on_page() {
		assertTrue(searchPage.verifyPage());
	}

}