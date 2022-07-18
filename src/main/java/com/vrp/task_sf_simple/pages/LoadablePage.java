package com.vrp.task_sf_simple.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class LoadablePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected WebDriver driver;

    protected LoadablePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clear and type")
    protected void clearAndType(WebElement inputBox, String text) {
        inputBox.clear();
        inputBox.sendKeys(text);
    }
}
