package com.vrp.task_sf_simple.pages.accounts;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditAccountForm extends AbstractAccountForm<EditAccountForm> {

    public EditAccountForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        // empty implementation
    }

    public EditAccountForm editAccountName(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .withMessage("Account Name input box is available.")
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> {
                    accountNameInput.click();
                    return accountNameInput;
                });
        accountNameInput.click();
        clearAndType(accountNameInput, text);
        return this;
    }

    public EditAccountForm editPhone(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .withMessage("Phone input box is available.")
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> {
                    phoneInput.click();
                    return phoneInput;
                });
        phoneInput.click();
        clearAndType(phoneInput, text);
        return this;
    }

    public ViewAccountPage save() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .withMessage("Save button is available.")
                .until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
        return new ViewAccountPage(driver);
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!(currentUrl.contains("r/Account") && currentUrl.contains("/edit"))) {
            throw new AssertionError("Edit Account form is not loaded.");
        }
    }
}
