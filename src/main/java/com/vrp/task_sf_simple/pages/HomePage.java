package com.vrp.task_sf_simple.pages;

import com.vrp.task_sf_simple.pages.accounts.AccountsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.vrp.task_sf_simple.config.EnvironmentConfig.BASE_URL;

public class HomePage extends LoadablePage<HomePage> {
    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='Account']")
    private WebElement accountsMainBarLabel;

    protected HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountsPage clickAccountMainBarLabel() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .withMessage("Account Name input box is available.")
                .until(ExpectedConditions.elementToBeClickable(accountsMainBarLabel));
        accountsMainBarLabel.click();
        return new AccountsPage(driver);
    }

    @Override
    protected void load() {
        driver.get(BASE_URL + "/lightning/page/home");
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.endsWith("page/home")) {
            throw new AssertionError("Home page is not loaded.");
        }
    }
}
