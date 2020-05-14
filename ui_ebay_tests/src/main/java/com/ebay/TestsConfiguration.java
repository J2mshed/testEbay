package com.ebay;

import com.ebay.configuration.Config;
import com.ebay.configuration.properties.PropertiesLoader;
import com.ebay.configuration.properties.Property;
import com.ebay.configuration.properties.PropertyFile;

@PropertyFile("config.properties")
public class TestsConfiguration extends Config {

    private static TestsConfiguration config;

    public static TestsConfiguration getConfig() {
        if (config == null) {
            config = new TestsConfiguration();
        }
        return config;
    }

    public TestsConfiguration() {
        PropertiesLoader.populate(this);
    }

    @Property("ebay.url")
    private String baseUrl;

    /**
     * @return Test Object URL
     */
    public String getBaseUrl() {
        return baseUrl;
    }
}
