package com.adactincucumber.hooks;

import com.adactincucumber.base.BaseClass;
import com.adactincucumber.configreader.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

import java.io.IOException;
import com.adactincucumber.driver.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.bidi.module.Browser;

public class Hooks extends BaseClass {
	ConfigReader config;
    @Before
    public void setup() throws IOException {
    	
    	config = new ConfigReader();

    //	String browser = config.getProperty("browser");
    	
        String browser = System.getProperty("browser");//browser was passed from the command line or Jenkins.so system.getproperty.mvn test -Dbrowser=firefox.no need to edit property file 
    	
    	
    	
    //   driver = getBrowser("chrome");
    //	driver=getBrowser(browser);
    	//driver = DriverManager.getDriver(browser);
    	 
    	if (browser == null || browser.isEmpty()) {
    	    browser = config.getProperty("browser");
    	}

    	System.out.println("Browser selected: " + browser);
    	
    	driver = DriverManager.getDriver(browser);
    	
    	
    	
      //  driver.get("https://adactinhotelapp.com/");
    	//driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

         /*   scenario.attach(
                    screenshot,
                    "image/png",
                    "Failure Screenshot"
            );*/
            scenario.attach(
                    screenshot,
                    "image/png",
                    "Failed - " + scenario.getName()
            );
        }

    //    driver.quit();
        DriverManager.quitDriver();
    }
}