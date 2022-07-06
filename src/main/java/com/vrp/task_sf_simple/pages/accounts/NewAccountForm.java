package com.vrp.task_sf_simple.pages.accounts;

import com.vrp.task_sf_simple.pages.LoadablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccountForm extends LoadablePage<NewAccountForm> {
    @FindBy(xpath = "//input[@id=//label[contains(.,'Account Name')]/@for]")
    private WebElement accountNameInput;
    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    public NewAccountForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterAccountName(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .withMessage("Account Name input box is available.")
                .until(ExpectedConditions.elementToBeClickable(accountNameInput));
        accountNameInput.click();
        accountNameInput.sendKeys(text);
        //saveButton.click();
    }

    @Override
    protected void load() {
        String baseUrl = System.getProperty("HOST");
        driver.get(baseUrl + "lightning/o/Account/new");
    }

    @Override
    protected void isLoaded() throws Error {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("o/Account/new")) {
            throw new AssertionError("New Account form is not loaded.");
        }
    }
}
