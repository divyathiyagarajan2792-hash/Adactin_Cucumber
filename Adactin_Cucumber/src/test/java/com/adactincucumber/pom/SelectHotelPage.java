package com.adactincucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	public WebDriver driver;
	
	public SelectHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name=\"radiobutton_0\"]")
	private WebElement selecthotel;
	
	@FindBy(xpath="//input[@name=\"continue\"]")
	private WebElement continueButton;
	
	public WebElement selectHotel()
	{
		return selecthotel;
	}

	public WebElement clickContinue()
	{
		return continueButton;
	}
}
