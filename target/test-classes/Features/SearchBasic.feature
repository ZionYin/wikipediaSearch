#Feature: link_to_business_plan
@regression @smoke
Feature: Test the basic search functionality of Wikipedia advanced search

  Scenario Outline: Valid search terms should return search results
    Given I am at the advanced search page of Wikipedia
    When I input a search term "<term>" in the search box
    And I click the search button
    Then I should verify the status "<status>" of the search

    Examples: 
      | term | status |
      | test | true   |
      | face | true   |
      | wiki | true   |
      | dskf | false  |
      | ytat | false  |
      | bhuq | false  |