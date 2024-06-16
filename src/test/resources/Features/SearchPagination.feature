#Feature: link_to_business_plan
@regression
Feature: Test search page pagination functionality

  Scenario: I navigate through multiple pages and verify the content
    Given I am at the advanced search page of Wikipedia
    When I input a search term "page" in the search box
    And I click the search button
    Then I should verify the status "true" of the search
    And I should be on page 1
    And I verify the content on page
    When I click on the previous page button
    Then I should be on page 1
    When I click on the next page button
    Then I should be on page 2
    And I verify the content on page
    When I click on the next page button
    Then I should be on page 3
    And I verify the content on page
    When I click on the previous page button
    Then I should be on page 2
    And I verify the content on page
    When I click on the previous page button
    Then I should be on page 1
    And I verify the content on page
    When I click on the previous page button
    Then I should be on page 1
    When I click on the previous page button
    Then I should be on page 1