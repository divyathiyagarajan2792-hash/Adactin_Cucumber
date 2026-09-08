package com.Adactin_Cucumber;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactincucumber.base.BaseClass;


public class Automation_Base extends BaseClass {
	
	public static WebDriver driver;
	
	public static void main(String[] args)
	
	{
		//driver = getBrowser("chrome");-----> remove comment otherwise it wont run 
		
		//WebDriver driver= new ChromeDriver();
		//driver.manage().window().maximize();
		
		get("https://adactinhotelapp.com/index.php");
		//driver.get("https://adactinhotelapp.com/index.php");
		
	
		
		
		//loginpage
		WebElement element = driver.findElement(By.id("username"));
		inputValue(element, "Divyathiyagarajan27");
		//driver.findElement(By.id("username")).sendKeys("Divyathiyagarajan27");
		
		WebElement element2 = driver.findElement(By.id("password"));
		inputValue(element2, "shivanya");
		//driver.findElement(By.id("password")).sendKeys();
		
		WebElement element3 = driver.findElement(By.id("login"));
		click(element3);
		//driver.findElement(By.id("login")).click();
		
		//Search Hotel page
		
	/*	WebElement element = driver.findElement(By.name("location"));
		Select select=new Select(element);
		List<WebElement> allOptions = select.getOptions();
		System.out.println("Total options:"+allOptions.size());
		for(WebElement option:allOptions)
		{
			System.out.println(option.getText());
		}
		Random random =new Random();
		int randomIndex = random.nextInt(allOptions.size()-1) + 1;
		System.out.println("Generated random index:"+randomIndex);
		select.selectByIndex(randomIndex);
		System.out.println("Selected random location:"+allOptions.get(randomIndex).getText());
		
		WebElement hotelDropElement = driver.findElement(By.name("hotels"));
		Select select2=new Select(hotelDropElement);
		List<WebElement> hotelOptions = select2.getOptions();
		Random random1=new Random();
		int randomIndex1 = random1.nextInt(hotelOptions.size()-1)+1;
		System.out.println("Generated random hotelIndex:"+randomIndex1);
		select2.selectByIndex(randomIndex1);
		System.out.println("selected hotel:"+ hotelOptions.get(randomIndex1).getText());
		
		WebElement roomTypeElement = driver.findElement(By.name("room_type"));
		Select sc=new Select(roomTypeElement);
		List<WebElement> roomOptions = sc.getOptions();
		Random ranIndex=new Random();
		int roomIndex = ranIndex.nextInt(roomOptions.size()-1)+1;
		System.out.println("room index:"+roomIndex);
		String text = roomOptions.get(roomIndex).getText();
		sc.selectByVisibleText(text);
		System.out.println("Selected text:"+text);
		
		WebElement roomnoElement = driver.findElement(By.name("room_nos"));
		Select s=new Select(roomnoElement);
		List<WebElement> roomnoOptions = s.getOptions();
		Random roomnoRandom=new Random();
		int roomnoIndex = roomnoRandom.nextInt(roomnoOptions.size()-1)+1;
		System.out.println("roomno Index:"+roomnoIndex);
		String value  = roomnoOptions.get(roomnoIndex).getAttribute("value");
		s.selectByValue(value);
		System.out.println("selected value:"+value);
		
		driver.findElement(By.id("datepick_in")).clear();
		driver.findElement(By.xpath("//input[@name=\"datepick_in\"]")).sendKeys("04/08/2026");
		
		driver.findElement(By.id("datepick_out")).clear();
		driver.findElement(By.id("datepick_out")).sendKeys("06/08/2026");
		
		Select sel = new Select(driver.findElement(By.name("adult_room")));
		sel.selectByValue("2");
		
		Select se =new Select(driver.findElement(By.id("child_room")));
		se.selectByVisibleText("1 - One");
		
		driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
		
		//Select hotel page
		
		driver.findElement(By.xpath("//input[@name=\"radiobutton_0\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"continue\"]")).click();
		
		//book a hotel page
		driver.findElement(By.name("first_name")).sendKeys("Divya");
		driver.findElement(By.name("last_name")).sendKeys("thiyagarajan");
		driver.findElement(By.name("address")).sendKeys("no.15,abc,texas");
		driver.findElement(By.name("cc_num")).sendKeys("1234567891234567");
		
		Select selec=new Select(driver.findElement(By.name("cc_type")));
		selec.selectByIndex(3);
		
		Select selectmon=new Select(driver.findElement(By.id("cc_exp_month")));
		selectmon.selectByValue("4");
		
		Select seldate=new Select(driver.findElement(By.name("cc_exp_year")));
		seldate.selectByVisibleText("2014");
		
		driver.findElement(By.name("cc_cvv")).sendKeys("1234");
		driver.findElement(By.id("book_now")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("my_itinerary")));
		
		//booking confirmation page
		driver.findElement(By.name("my_itinerary")).click();
		
		//booked Itinerary page
		driver.findElement(By.xpath("//input[contains (@value,'Cancel')]")).click();
		
		Alert alert= driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("logout")).click();
		
	*/	
		
	}
	}
	
	
	


