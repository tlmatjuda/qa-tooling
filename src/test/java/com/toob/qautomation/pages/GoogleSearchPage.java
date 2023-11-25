package com.toob.qautomation.pages;

import com.toob.qautomation.props.QaProps;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@Component
public class GoogleSearchPage {

    @Autowired
    private QaProps qaProps;

    @Autowired
    private WebDriver driver;

    private final By searchBoxLocator = By.name("q");
    private final By searchButtonLocator = By.name("btnK");

    public void open() {
        driver.get( qaProps.getTargetWebUrl());
    }

    public void performSearch(String searchText) {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        assertNotNull( searchBox);
        searchBox.sendKeys(searchText);
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(searchButtonLocator);
        assertNotNull(searchButton);
        searchButton.click();
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(qaProps.getWaitTimeOutSeconds()));
        wait.until( ExpectedConditions.titleContains(" - Google Search"));
        driver.quit();
    }

}
