package com.ebay.pageObjects;

import com.ebay.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.*;

public class ItemsPage extends BasePage {

    public void isPageOpened(){
        getWait().until(ExpectedConditions.titleContains(" | eBay"));
        getWait().until(ExpectedConditions.urlContains("/itm/"));
    }

    @Then("^I am on Items page$")
    public void iAmOnItemsPage() {
        isPageOpened();
    }

    @When("^I click on 'Add to cart' button on Items page$")
    public CartPayments iClickOnAddToCartButtonOnItemsPage() {
        click(By.id("isCartBtn_btn"));
        return new CartPayments();
    }
    @When("^I click on 'Add to cart' button on Items page popup page come$")
    public YouAreAlmostDoneForm iClickOnAddToCartButtonOnItemsPagePPPCome() {
        click(By.id("isCartBtn_btn"));
        return new YouAreAlmostDoneForm();
    }
}