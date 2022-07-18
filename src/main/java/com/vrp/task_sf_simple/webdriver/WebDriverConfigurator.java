package com.vrp.task_sf_simple.webdriver;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Set;

public final class WebDriverConfigurator {
    private static final Logger logger = LogManager.getLogger();

    private WebDriverConfigurator() {
    }

    public static void configure(WebDriver driver) {
        driver.manage().window().maximize();
        logger.debug("WebDriver instance is configured.");
    }

    public static void printCapabilities(WebDriver driver) {
        Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
        Map<String, Object> map = capabilities.asMap();
        Set<String> keys = map.keySet();
        StringBuilder sb = new StringBuilder("WebDriver capabilities: \n");
        keys.stream().sorted().forEach(key -> {
                    Object value = map.get(key);
                    sb.append(key);
                    sb.append(" = ");
                    sb.append(value);
                    sb.append("\n");
                }
        );
        logger.log(Level.DEBUG, sb);
    }
}
