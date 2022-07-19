package com.vrp.task_sf_simple.junit;

import com.vrp.task_sf_simple.allure.AllureScreenshot;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;

public class FailedTestWatcher implements TestWatcher {
    private final AllureScreenshot allureScreenshot;

    public FailedTestWatcher(WebDriver driver) {
        this.allureScreenshot = new AllureScreenshot(driver);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        allureScreenshot.attach();
    }
}
