package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.webdriver.BrowserType;
import com.vrp.task_sf_simple.webdriver.WebDriverConfigurator;
import com.vrp.task_sf_simple.webdriver.WebDriverFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class TestBase {
    static WebDriver driver;

    @BeforeAll
    static void initWebDriver() {
        driver = WebDriverFactory.getWebDriver(BrowserType.valueOf("CHROME"));
        WebDriverConfigurator.configure(driver);
        WebDriverConfigurator.printCapabilities(driver);
    }
}
