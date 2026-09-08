package com.adactincucumber.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {

    private static WebDriver driver;

    // Private constructor
    private DriverManager() {

    }

    // Singleton method
    public static WebDriver getDriver(String browser) {

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("ie")) {
                driver = new InternetExplorerDriver();
                
            }else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();

            } else {
                throw new IllegalArgumentException(
                        "Invalid browser: " + browser);
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}