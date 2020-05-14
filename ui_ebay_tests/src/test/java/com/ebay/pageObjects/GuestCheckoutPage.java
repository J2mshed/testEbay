package com.ebay.pageObjects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.ebay.helpers.ElementsInteraction.getWait;
import static com.ebay.helpers.ElementsInteraction.*;

public class GuestCheckoutPage {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleContains("Checkout | eBay"));
    }

    @Then("^I am on Guest Checkout page$")
    public void iAmOnGuestCheckoutPage() {
        isPageOpened();
    }

    @Then("^Page contains '(.*)' itemName on Checkout page$")
    public void pageContainsItemsOnCheckoutPage(String item) {
        By itemName = (By.xpath(String.format("//div[@class='item-title']//span[.='%s']", item)));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(itemName));
    }

    /*    @Then("^I change the quantity of item to '(.*)' on Checkout page$")
        public void iChangeTheQuantity(String quantity) {
    //        By quantityOfItem = (By.xpath("//select[@data-test-id='CART_DETAILS_ITEM_QUANTITY']"));
            Select select = new Select(By.xpath("//select[@data-test-id='CART_DETAILS_ITEM_QUANTITY']"));
            select.selectByValue(quantity);


    //        getWait().until(ExpectedConditions.visibilityOfElementLocated(quantityOfItem));
        }

        @When("^I select '(.*)' as ship country on Checkout page")
        public void iSelectCountryToShip(String country){
            By shipCountry = (By.id(String.format("country", country)));
            Select select = new Select(shipCountry);
                    select.selectByVisibleText(country);
        }
    */
    @And("^I set '(.*)' as first name on Checkout page$")
    public void iSetNameAsFirstName(String firstName) {
        sendKeys(By.id("firstName"), firstName);
    }

    @And("^I set '(.*)' as last name on Checkout page$")
    public void iSetNameAsLasttName(String lastName) {
        sendKeys(By.id("lastName"), lastName);
    }

    @And("^I set '(.*)' as Street address on Checkout page$")
    public void iSetStreetAddress(String streetAddress) {
        sendKeys(By.id("addressLine1"), streetAddress);
    }

}
