package com.vrp.task_sf_simple.pages.accounts;

import com.vrp.task_sf_simple.pages.LoadablePage;
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

    public String getPhone() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .withMessage("Phone number is displayed.")
                .until(ExpectedConditions.elementToBeClickable(phone));
        return phone.getText();
    }

    @Override
    protected void load() {
        //not implemented
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!(currentUrl.contains("r/Account") && currentUrl.contains("/view"))) {
            throw new AssertionError("View Account form is not loaded.");
        }
    }
}
