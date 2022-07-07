package com.vrp.task_sf_simple.webdriver;

import com.vrp.task_sf_simple.utils.FileSystemUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverChromeCreator implements WebDriverCreator {

    @Override
    public WebDriver create() {
        ChromeOptions options = initChromeOptions();
        return new ChromeDriver(options);
    }

    private ChromeOptions initChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        options.addArguments("--incognito");
        String userDataDir = "--user-data-dir=" + FileSystemUtil.getCurrentDirAbsolutePath() + "/chrome-test-profile";
        options.addArguments(userDataDir);
        return options;
    }
}
