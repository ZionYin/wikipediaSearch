#Feature: link_to_business_plan
@regression
Feature: Test the search suggestions feature

  Scenario Outline: I can see search suggestions for valid search terms
    Given I am at the advanced search page of Wikipedia
    When I input a search term "<term>" in the search box
    Then Search suggestions should be displayed
    And Suggestions should contain suggestion "<suggestion>"

    Examples: 
      | term  | suggestion     |
      | face  | facebook       |
      | bana  | banana         |
      | Turin | Turing Machine |

  Scenario Outline: User sees no suggestions for invalid search terms
    Given I am at the advanced search page of Wikipedia
    When I input a search term "<term>" in the search box
    Then No search suggestions should be displayed

    Examples: 
      | term   |
      | dskfff |
      | tbrotq |
      | ssooii |