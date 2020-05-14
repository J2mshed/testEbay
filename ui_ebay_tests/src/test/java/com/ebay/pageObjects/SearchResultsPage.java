package com.ebay.pageObjects;

import com.ebay.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.ebay.helpers.ElementsInteraction.*;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class SearchResultsPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleContains(" | eBay"));
        getWait().until(ExpectedConditions.urlContains("/sch/"));
    }

    @And("^I am on Search results page$")
    public void iAmOnSearchResultsPage() {
        isPageOpened();
    }


    @And("^I click on '(.*)' item name on Search results page$")
    public ItemsPage iClickOnCourseNameOnSearchResultsPage(String itemName) {
//        click(By.xpath("//div[.='" + courseName + "']"));
        click(By.xpath(String.format("//a[.='%s']", itemName)));
        return new ItemsPage();
    }
//    other step definitions go here
}

