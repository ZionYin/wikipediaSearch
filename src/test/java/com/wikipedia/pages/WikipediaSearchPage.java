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
	
	@FindBy(css = ".mw-prevlink")
	private List<WebElement> prevButtons;
	
	@FindBy(css = ".mw-nextlink")
	private List<WebElement> nextButtons;
	
	@FindBy(css = ".results-info")
	private WebElement resultInfo;
	
	@FindBy(css = ".mw-search-result")
	private List<WebElement> searchResults;

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
	
	public void clickSearchBox() {
		searchBox.click();
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
	
	public void clickNextButton() {
		nextButtons.getFirst().click();
		
	}

	public void clickPreviousButton() {
		prevButtons.getFirst().click();
		
	}

	public boolean isOnPage(Integer expectedPageNum) {
		// For now, assume the grouping limit is always 20. In the future need to parameteralize 
		// the number as well
		int offset = Integer.parseInt((resultInfo.getAttribute("data-mw-num-results-offset")));
		int actualPageNum = (offset / 20 ) + 1;
		return actualPageNum == expectedPageNum;
	}

	public boolean verifyPage() {
		// For now, only verify that there are 20 results in a single page
		return searchResults.size() == 20;
	}


}
