package com.toob.qautomation.steps;

import com.toob.qautomation.integration.CucumberSpringIntegration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class PlanetsSteps extends CucumberSpringIntegration {

    @Autowired
    private RestTemplate restTemplate;

    String planetsResponseText = StringUtils.EMPTY;

    @BeforeEach
    void setUp() {

    }

    @Given("^The Planets Have Been Fetched:$")
    public void planetsHaveLoaded() {
        planetsResponseText = restTemplate.getForObject("/planets", String.class);
        assertTrue( StringUtils.isNotBlank( planetsResponseText));
    }

    @Then("Print Them Out For Me")
    public void printThemOutForMe() {
        log.info("Here are the Planets : {}", planetsResponseText);
    }
}
