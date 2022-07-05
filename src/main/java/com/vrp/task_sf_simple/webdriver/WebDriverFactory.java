package com.vrp.task_sf_simple.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(BrowserType type) {
        switch (type) {
            case CHROME:
                WebDriverChromeCreator webDriverChromeCreator = new WebDriverChromeCreator();
                return webDriverChromeCreator.create();
            default:
                throw new IllegalArgumentException("Incorrect web driver type");
        }
    }



}
