package com.wikipedia.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

	@FindBy(id = "ooui-php-1")
	private WebElement searchBox;

	@FindBy(css = "button.oo-ui-inputWidget-input")
	private WebElement searchButton;

	@FindBy(css = ".mw-search-exists")
	private List<WebElement> searchResultsExistIndicator;
	
	@FindBy(css = "a.oo-ui-labelElement-label")
	private List<WebElement> searchSuggestionsList;

	private WebDriver driver = null;

	public WikipediaSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToSearchPage() {
		driver.get("https://en.wikipedia.org/w/index.php?search");
	}

	public void inputSearchTerm(String term) {
		searchBox.sendKeys(term);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public boolean hasSearchResult() {
		return searchResultsExistIndicator.size() > 0;
	}
	
	public void waitForOneSecond() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	
	public boolean hasSearchSuggestion() {
		return searchSuggestionsList.size() > 0;
	}
	
	
	
	public boolean containSuggestion(String suggestion) {
		suggestion = suggestion.toLowerCase();
		for (WebElement searchSuggestion: searchSuggestionsList) {
			if (searchSuggestion.getText().toLowerCase().contains(suggestion)) {
				return true;
			}
		}
		return false;
	}

}
