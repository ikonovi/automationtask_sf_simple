package com.vrp.task_sf_simple.pages.accounts;

import com.vrp.task_sf_simple.pages.LoadablePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.vrp.task_sf_simple.configs.SystemProperties.BASE_URL;

public class AccountsPage extends LoadablePage<AccountsPage> {
    @FindBy(xpath = "//li[@data-target-selection-name='sfdc:StandardButton.Account.New']")
    private WebElement newButton;

    public AccountsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Click New")
    public NewAccountForm clickNew() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .withMessage("New button is available")
                .until(ExpectedConditions.elementToBeClickable(newButton));
        newButton.click();
        return new NewAccountForm(driver);
    }

    @Override
    protected void load() {
        driver.get(BASE_URL + "/lightning/o/Account/list");
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("o/Account")) {
            throw new AssertionError("Account page is not loaded.");
        }
    }
}
