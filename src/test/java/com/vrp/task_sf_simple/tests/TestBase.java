package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.webdriver.BrowserType;
import com.vrp.task_sf_simple.webdriver.WebDriverFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class TestBase {
    static String host;
    static String userName;
    static String password;
    static WebDriver webDriver;

    @BeforeAll
    static void initAll() {
        host = System.getProperty("HOST");
        userName = System.getProperty("USER");
        password = System.getProperty("PWD");
        webDriver = WebDriverFactory.getWebDriver(BrowserType.valueOf("CHROME"));
    }
}
