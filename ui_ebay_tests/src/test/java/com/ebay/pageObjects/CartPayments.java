package com.ebay.pageObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.*;

public class CartPayments {

    public void isPageOpened(){
        getWait().until(ExpectedConditions.titleContains("eBay shopping cart"));
//        getWait().until(ExpectedConditions.textToBe
//                (By.xpath("//a[@data-test-id='cart-item-link']"),
//                        "6 x 76A Duracell 1.5V Alkaline Button Batteries (LR44, A76, EPX76, PX76A, V136A)"));
    }
    @Then("^I am on Cart Payments page$")
    public void iAmOnCartPaymentsPage() throws InterruptedException {
        isPageOpened();
    }
    @Then("^Cart Payments contains '(.*)' on Cart Payments page$")
    public void cartPaymentsContainsItemsInside(String item){
        By itemName = (By.xpath(String.format("//a[@data-test-id='cart-item-link']//span[.='%s']", item)));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(itemName));
    }
    @Then("^Cart subtotal is '(.*)' on Cart Payments page$")
    public void cartSubtotalIs(String subtotal){
        By price = (By.xpath(String.format("//div[@data-test-id='TOTAL']//span[.='$%s']", subtotal)));
//        assertElementValue(price, subtotal);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(price));
    }
    @When("^I click on 'Go to checkout' button on Cart Payments page$")
    public ContinueToSignInOrAsGuest iClickOnGoToCheckoutPage() {
        click(By.xpath("//button[@data-test-id='cta-top']"));
        return new ContinueToSignInOrAsGuest();
    }
}
