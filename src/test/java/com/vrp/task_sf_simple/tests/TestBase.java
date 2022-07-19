package com.vrp.task_sf_simple.tests;

import com.vrp.task_sf_simple.pages.HomePage;
import com.vrp.task_sf_simple.pages.LoginPage;
import com.vrp.task_sf_simple.junit.FailedTestWatcher;
import com.vrp.task_sf_simple.webdriver.BrowserType;
import com.vrp.task_sf_simple.webdriver.WebDriverConfigurator;
import com.vrp.task_sf_simple.webdriver.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;

import static com.vrp.task_sf_simple.configs.SystemProperties.PASSWORD;
import static com.vrp.task_sf_simple.configs.SystemProperties.USER_NAME;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {
    protected WebDriver driver = WebDriverFactory.getWebDriver(BrowserType.valueOf("CHROME"));
    protected HomePage homePage;

    @RegisterExtension
    private final FailedTestWatcher failedTestWatcher = new FailedTestWatcher(driver);

    @BeforeAll
    void beforeAll() {
        initWebDriver();
        login();
    }

    @AfterAll
    void afterAll() {
        driver.quit();
    }

    private void initWebDriver() {
        WebDriverConfigurator.configure(driver);
        WebDriverConfigurator.printCapabilities(driver);
    }

    private void login() {
        LoginPage loginPage = new LoginPage(driver).get();
        homePage = loginPage
                .enterUsername(USER_NAME)
                .enterPassword(PASSWORD)
                .clickLogin();
    }
}
