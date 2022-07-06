package com.vrp.task_sf_simple.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoadablePage<LoginPage> {
    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "pw")
    private WebElement passwordInput;
    @FindBy(name = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String userName) {
        clearAndType(usernameInput, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clearAndType(passwordInput, password);
        return this;
    }

    public HomePage clickLogin() {
        loginButton.submit();
        return new HomePage(driver);
    }

    private void clearAndType(WebElement inputBox, String text) {
        inputBox.clear();
        inputBox.sendKeys(text);
    }

    @Override
    protected void load() {
        String baseUrl = System.getProperty("HOST");
        driver.get(baseUrl);
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            loginButton.isEnabled();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Could not find the Login button. Login page is not loaded.");
        }
    }
}
