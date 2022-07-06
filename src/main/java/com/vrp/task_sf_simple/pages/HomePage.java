package com.vrp.task_sf_simple.pages;

import com.vrp.task_sf_simple.pages.accounts.AccountsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends LoadablePage<HomePage> {
    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id='Account']")
    private WebElement accountsMainBarLabel;

    protected HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountsPage clickAccountMainBarLabel() {
        accountsMainBarLabel.click();
        return new AccountsPage(driver);
    }

    @Override
    protected void load() {
        String baseUrl = System.getProperty("HOST");
        driver.get(baseUrl + "/lightning/page/home");
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.endsWith("page/home")) {
            throw new AssertionError("Home page is not loaded.");
        }
    }
}
