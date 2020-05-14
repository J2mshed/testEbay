package com.ebay.pageObjects;

import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.*;

public class ProtectYourPurchaseWithSQ {

    public void isPageOpened() throws InterruptedException {
        wait(5000);
        getWait().until(ExpectedConditions.titleIs("Protect your purchase with SquareTrade"));
    }
    @Then("^I am on Protect Purchase page$")
    public void iAmOnProtectPurchasePage() throws InterruptedException { isPageOpened();}
}
