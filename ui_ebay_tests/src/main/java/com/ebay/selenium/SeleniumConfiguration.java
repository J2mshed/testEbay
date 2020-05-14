package com.ebay.selenium;

import com.ebay.configuration.Config;
import com.ebay.configuration.properties.PropertiesLoader;
import com.ebay.configuration.properties.Property;
import com.ebay.configuration.properties.PropertyFile;

/**
 * Class for base tests properties - urls for test, browser name and version
 */
@PropertyFile("config.properties")
public class SeleniumConfiguration extends Config {

    private static SeleniumConfiguration config;

    public static SeleniumConfiguration getConfig() {
        if (config == null) {
            config = new SeleniumConfiguration();
        }
        return config;
    }

    public SeleniumConfiguration() {
        PropertiesLoader.populate(this);
    }

    @Property("selenium.browser.isGrid")
    private String isSeleniumGrid;

    /**
     * @return false for local selenium browser and true for selenium grid
     */
    public boolean getSeleniumBrowserIsGrid() {
        return Boolean.parseBoolean(isSeleniumGrid);
    }

    @Property("selenium.browser.enableScreenShotsCapture")
    private String enableScreenShotsCapture;

    /**
     * @return switch for taking screenshot on page transition
     */
    public boolean getEnableScreenShotsCapture() {
        return Boolean.parseBoolean(enableScreenShotsCapture);
    }

    @Property("selenium.browser.enableVNC")
    private String enableVNC;

    /**
     * @return switch for taking screenshot on page transition
     */
    public boolean getSeleniumBrowserEnableVNC() {
        return Boolean.parseBoolean(enableVNC);
    }

    @Property("selenium.browser.enableVideo")
    private String enableVideo;

    /**
     * @return switch for taking video on test execution
     */
    public boolean getSeleniumBrowserEnableVideo() {
        return Boolean.parseBoolean(enableVideo);
    }

    @Property("selenium.browser.pageLoadingRetriesCount")
    private String pageLoadingRetriesCount;

    /**
     * @return page loading retries count
     */
    public int getPageLoadingRetriesCount() {
        return Integer.parseInt(pageLoadingRetriesCount);
    }

    @Property("selenium.browser.name")
    private String browser;

    /**
     * @return browser name
     */
    public String getBrowser() {
        return browser;
    }

    @Property("selenium.grid.browser.version")
    private String version;

    /**
     * @return browser version
     */
    public String getBrowserVersion() {
        return version;
    }

    @Property("selenium.grid.browser.os")
    private String os;

    /**
     * @return browser os
     */
    public String getBrowserOs() {
        return os;
    }

    @Property("selenium.grid.browser.timeZone")
    private String timeZone;

    /**
     * @return browser timezone
     */
    public String getBrowserTimeZone() {
        return timeZone;
    }

    @Property("selenium.grid.url")
    private String gridUrl;

    /**
     * @return URL to selenium grid
     */
    public String getSeleniumGridUrl() {
        return gridUrl;
    }
}
