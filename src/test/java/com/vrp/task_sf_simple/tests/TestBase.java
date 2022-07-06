package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.webdriver.BrowserType;
import com.vrp.task_sf_simple.webdriver.WebDriverFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class TestBase {
    static WebDriver driver;

    @BeforeAll
    static void initAll() {
        driver = WebDriverFactory.getWebDriver(BrowserType.valueOf("CHROME"));
    }
}
