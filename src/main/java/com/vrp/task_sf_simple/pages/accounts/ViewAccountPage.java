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

public class ViewAccountPage extends LoadablePage<NewAccountForm> {
    @FindBy(xpath = "//div[contains(@class,'entityNameTitle')]/../slot//lightning-formatted-text")
    private WebElement accountName;
    @FindBy(xpath = "//li[@data-target-selection-name='sfdc:StandardButton.Account.Edit']")
    private WebElement editButton;
    @FindBy(xpath = "//li[@data-target-selection-name='sfdc:StandardButton.Account.Delete']")
    private WebElement deleteButton;
    @FindBy(xpath = "//p[contains(@title,'Phone')]/following-sibling::p")
    private WebElement phone;

    protected ViewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .withMessage("Account Name is displayed.")
                .until(ExpectedConditions.elementToBeClickable(accountName));
        return accountName.getText();
    }

    @Step("Is Account updated to?")
    public boolean isAccountUpdatedTo(String text) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .withMessage("Wait till Account Name get updated to " + text)
                    .until(driver -> accountName.getText().equals(text));
        } catch (org.openqa.selenium.TimeoutException e) {
            // log exemption message in here
            return false;
        }
    }

    public String getPhone() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .withMessage("Phone number is displayed.")
                .until(ExpectedConditions.elementToBeClickable(phone));
        return phone.getText();
    }

    @Step("Is phone updated to?")
    public boolean isPhoneUpdatedTo(String text) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(5))
                    .withMessage("Wait till Phone get updated to " + text)
                    .until(driver -> phone.getText().equals(text));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    @Step("Click Edit")
    public EditAccountForm clickEdit() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .withMessage("Edit button is clickable.")
                .until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        return new EditAccountForm(driver);
    }

    @Override
    protected void load() {
        // empty implementation
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!(currentUrl.contains("r/Account") && currentUrl.contains("/view"))) {
            throw new AssertionError("View Account form is not loaded.");
        }
    }
}
