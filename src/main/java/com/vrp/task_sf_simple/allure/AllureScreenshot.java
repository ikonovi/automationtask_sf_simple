package com.vrp.task_sf_simple.allure;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureScreenshot {
    private final WebDriver driver;

    public AllureScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void attach() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
    }
}
