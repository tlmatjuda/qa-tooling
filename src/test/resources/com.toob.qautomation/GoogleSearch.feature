Feature: Google Search

  Scenario: Perform a Google search
    Given I open the Google search page
    When I perform a search with the keyword "Selenium WebDriver"
    And I click the search button
    Then I should see search results page

