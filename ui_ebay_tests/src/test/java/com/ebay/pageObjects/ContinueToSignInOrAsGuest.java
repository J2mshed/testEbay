package com.ebay.pageObjects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.ebay.helpers.ElementsInteraction.click;
import static com.ebay.helpers.ElementsInteraction.getWait;

public class ContinueToSignInOrAsGuest {
    public void isPageOpened() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.id("signin-btn")));
    }
    @Then("^I am on Continue Verification page$")
    public void iAmOnContinueVerificationPage(){ isPageOpened();}

    @When("^I click on 'Continue to signin' button on Verifications page$")
    public SignInPage iClickOnContinueToSignin(){
        click(By.id("signin-btn"));
        return new SignInPage();
    }
    @When("^I click on 'Continue as guest' button on Verifications page$")
    public GuestCheckoutPage iClickOnContinueAsGuest(){
        click(By.id("gxo-btn"));
        return new GuestCheckoutPage();
    }
}
