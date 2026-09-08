package com.adactincucumber.base;

import java.util.List;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactincucumber.driver.DriverManager;

public class BaseClass {

	protected static WebDriver driver;
	
/*	public static WebDriver getBrowser(String type)

	{
		if(type.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(type.equalsIgnoreCase("ie")){
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver;	
	}*/
	

	
	public static void click(WebElement element) 
	{
		element.click();
	}
	
	public static void inputValue(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	
	public static void get(String value)
	{
		driver.get(value);
		}
	
/*	public static void getElement(WebElement element, String type) {
		try {
			if(type.equalsIgnoreCase("gettext")){
				String text = element.getText();
				System.out.println(text);
			}else if (type.equalsIgnoreCase("getAttribute")) {
				String attribute = element.getAttribute(null);
				System.out.println(attribute);
				
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
	}*/
	
	public static String getText(WebElement element) {
	    return element.getText();
	}

	public static String getAttribute(WebElement element, String attribute) {
	    return element.getAttribute(attribute);
	}
		
		public static void select(WebElement element, String type, String value)
		{
			Select dropdown=new Select(element);
			if(type.equalsIgnoreCase("index")) {
				int parseInt = Integer.parseInt(value);
				dropdown.selectByIndex(parseInt);
			}else if (type.equalsIgnoreCase("value"))
			{
				dropdown.selectByValue(value);
			}
			else if (type.equalsIgnoreCase("visibletext")) {
				dropdown.selectByVisibleText(value);
			}
			
			
		}
		
		public static void acceptAlert() {
			driver.switchTo().alert().accept();
		}
		 public static void dismissAlert() {
		        driver.switchTo().alert().dismiss();   
		    }
		 
		 public static String getAlertText() {
			
			        Alert alert = driver.switchTo().alert();
			        return alert.getText();
			    }

		    // Send Text to Alert
		    public static void sendAlertText(String value) {
		      driver.switchTo().alert().sendKeys(value);
		    }
		    
		public static void allOptions(WebElement element) {
			Select dropdown=new Select(element);
			List<WebElement> options = dropdown.getOptions();
			   System.out.println("Total Options: " + options.size());
			for(WebElement option: options) {
				System.out.println(option.getText());
			}
		}
		
		public static void selectRandomOption(WebElement element,String type) {
			Select dropdown=new Select(element);
			List<WebElement> allOptions = dropdown.getOptions();
			Random random =new Random();
			int randomIndex = random.nextInt(allOptions.size()-1) + 1;
			
			if(type.equalsIgnoreCase("index")) {
			dropdown.selectByIndex(randomIndex);
			}
			else if (type.equalsIgnoreCase("visibletext")) {
				String text = allOptions.get(randomIndex).getText();
				dropdown.selectByVisibleText(text);
			}
			else if(type.equalsIgnoreCase("value")) {
				String value  = allOptions.get(randomIndex).getAttribute("value");
				dropdown.selectByValue(value);
			}
			
		}
		public static void waitForElement(WebElement element) {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public static void waitForElementToBeClickable(WebElement element) {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		}



