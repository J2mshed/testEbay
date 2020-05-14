package com.ebay.pageObjects;

import com.ebay.TestsConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.ebay.CucumberHooks.getDriver;
import static com.ebay.TestsConfiguration.getConfig;


public class GlobalSteps {
    @Given("^I open start page$")
    public StartPage openStartPage() {
        String baseUrl = TestsConfiguration.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new StartPage();
    }
    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}
