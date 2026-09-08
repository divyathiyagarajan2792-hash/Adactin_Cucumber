package com.adactincucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmationPage {
	
	public WebDriver driver;
	
	public BookingConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="my_itinerary")
	private WebElement confirmationClick;
	
	public WebElement confirmClick() {
		return confirmationClick;
	}
	

}
