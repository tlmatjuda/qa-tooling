package com.toob.qautomation.steps;

import com.toob.qautomation.integration.CucumberSpringIntegration;
import com.toob.qautomation.pages.GoogleSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GoogleSteps extends CucumberSpringIntegration {

    @Autowired
    private GoogleSearchPage googleSearchPage;

    @Given("I open the Google search page")
    public void openBrowser() {
        googleSearchPage.open();
    }

    @When("I perform a search with the keyword {string}")
    public void performSearch(String searchText) {
        googleSearchPage.performSearch(searchText);
    }

    @And("I click the search button")
    public void clickSearchButton() {
        googleSearchPage.clickSearchButton();
    }

    @Then("I should see search results page")
    public void verifySearchResultsPage() {
        googleSearchPage.waitForPageToLoad();
    }
}
