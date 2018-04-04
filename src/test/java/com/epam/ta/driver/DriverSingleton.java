package com.epam.ta.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static final Logger logger = LogManager.getRootLogger();
    private static final String CHROMEDRIVER = "driverBinary/chromedriver.exe";
    private static final String CHROMEBINARY = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty("webdriver.chrome.driver", CHROMEDRIVER);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(CHROMEBINARY);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            logger.info("Browser started");
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
        logger.info("Browser stopped");
    }
}
