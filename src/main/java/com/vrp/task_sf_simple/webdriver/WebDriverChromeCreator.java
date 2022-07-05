package com.vrp.task_sf_simple.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverChromeCreator implements WebDriverCreator {

    @Override
    public WebDriver create() {
        return new ChromeDriver();
    }
}
