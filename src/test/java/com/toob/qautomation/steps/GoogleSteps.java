package com.toob.qautomation.steps;

import com.toob.qautomation.constants.GoogleConstants;
import com.toob.qautomation.integration.CucumberSpringIntegration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GoogleSteps extends CucumberSpringIntegration {

    private WebDriverWait webDriverWait;

    @Before
    void setUp() {
        webDriverWait = new WebDriverWait( webDriver, Duration.ofSeconds( waitTimeOutSeconds));
    }

    @Given("^That the web page is loaded")
    public void webPageIsLoaded() {
        // Go to the website
        assertNotNull( webDriver);
        webDriver.get(targetWebUrl);
    }

    @When("^I type in the search box")
    public void insertIntoSearchBox() {
        // Look for the search textbox or textarea and type in Mix Telematics
        WebElement searchBox = webDriver.findElement( By.name(GoogleConstants.ELEMENT_SEARCH_BOX));
        assertNotNull( searchBox);
        searchBox.sendKeys("Mix Telematics");
    }

    @And("^Click the \"Google Search\" button")
    public void shouldClickAndSearch() {
        // Now look for the Google Search Button and click if
        WebElement googleSearchButton = webDriver.findElement(By.name(GoogleConstants.ELEMENT_SEARCH_BOX));
        assertNotNull( googleSearchButton);
        googleSearchButton.click();
    }

    @Then("^I will get results of what I searched for")
    public void shouldGetResults() {
        // Wait until the page has loaded.
        webDriverWait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @After
    void tearDown() {
        if (Objects.nonNull( webDriver)) {
            webDriver.quit();
        }
    }
}
