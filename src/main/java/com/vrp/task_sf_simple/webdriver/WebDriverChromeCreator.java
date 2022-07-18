package com.vrp.task_sf_simple.webdriver;

import com.vrp.task_sf_simple.utils.FileSystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverChromeCreator implements WebDriverCreator {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public WebDriver create() {
        ChromeOptions options = initChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver(options);
        logger.debug("ChromeDriver instance is created");
        return chromeDriver;
    }

    private ChromeOptions initChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        options.addArguments("--incognito");
        options.addArguments(composeUserDataDir());
        return options;
    }

    private String composeUserDataDir() {
        final String userDataDirName = "chrome-test-profile";
        return "--user-data-dir=" + FileSystemUtil.getCurrentDirAbsolutePath() + "/" + userDataDirName;
    }
}
