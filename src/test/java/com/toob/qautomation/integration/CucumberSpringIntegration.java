package com.toob.qautomation.integration;


import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


/**
 * CucumberSpringIntegration brings dependency injection to our Cucumber tests.
 * It enables Cucumber to use Spring Context for test scenario execution.
 *
 * @CucumberContextConfiguration annotation tells Cucumber to use this class as the test context configuration for Spring.
 *
 * @SpringBootTest Since we’re using Spring Boot, we annotate this configuration class with this annotation.
 */
@Slf4j
@CucumberContextConfiguration
@SpringBootTest
public class CucumberSpringIntegration {

    @Value("${qa.tooling.web.driver.target.url}")
    protected String targetWebUrl;

    @Value("${qa.tooling.web.driver.wait-timeout-seconds}")
    protected int waitTimeOutSeconds;

//
//    @Autowired
//    protected WebDriver webDriver;

}
