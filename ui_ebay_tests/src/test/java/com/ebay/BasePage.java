package com.ebay;

import com.ebay.selenium.SeleniumConfiguration;
import com.ebay.selenium.WaitForAjaxCalls;
import com.ebay.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ebay.CucumberHooks.getContext;
import static com.ebay.CucumberHooks.getDriver;

/**
 * This is the main class for page objects
 */
public abstract class BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    /**
     * checks is page opened
     */
    public abstract void isPageOpened();

    /**
     * This constructor is just for the internal Cucumber use as on first call of a step from any page
     * object. Use constructor with boolean parameter
     */
    public BasePage() {
    }

    public BasePage(boolean captureScreenShot) {
        String pageName = this.getClass().getSimpleName();
        getContext().setPageName(pageName);
        LOG.debug("open {}", pageName);
        waitForOpen();
        if (captureScreenShot && SeleniumConfiguration.getConfig().getEnableScreenShotsCapture()) {
            WebDriverFactory.captureScreenshot(getContext(), getDriver(), pageName);
        }
    }

    /**
     * Waiting for page opening
     */
    protected void waitForOpen() {
        LOG.info("{} page loading started", this.getClass().getSimpleName());
        long currentTime = System.currentTimeMillis();
        new WaitForAjaxCalls(getDriver()).checkPendingRequests();
        try {
            isPageOpened();
        } catch (WebDriverException e) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " page was not opened!", e.getCause());
        }
        LOG.info(String.format("%s page loaded in %.1f s on %s url",
                this.getClass().getSimpleName(),
                (float) (System.currentTimeMillis() - currentTime) / 1000,
                getDriver().getCurrentUrl()));
    }
}
