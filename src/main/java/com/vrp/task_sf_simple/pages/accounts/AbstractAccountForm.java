package com.vrp.task_sf_simple.pages.accounts;

import com.vrp.task_sf_simple.pages.LoadablePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractAccountForm<T extends LoadablePage<T>> extends LoadablePage<T> {
    @FindBy(xpath = "//input[@id=//label[contains(.,'Account Name')]/@for]")
    protected WebElement accountNameInput;
    @FindBy(xpath = "//input[@id=//label[contains(.,'Phone')]/@for]")
    protected WebElement phoneInput;
    @FindBy(xpath = "//button[@title='Save']")
    protected WebElement saveButton;

    protected AbstractAccountForm(WebDriver driver) {
        super(driver);
    }
}
