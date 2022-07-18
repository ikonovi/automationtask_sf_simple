package com.vrp.task_sf_simple.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver(BrowserType type) {
        WebDriver driver;
        if (type == BrowserType.CHROME) {
            WebDriverChromeCreator webDriverChromeCreator = new WebDriverChromeCreator();
            driver = webDriverChromeCreator.create();
        } else {
            throw new IllegalArgumentException("Incorrect web driver type");
        }
        return driver;
    }
}
