package com.adactincucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingItineraryPage {

		
		public WebDriver driver;
		
		public BookingItineraryPage (WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath="//input[contains (@value,'Cancel')]")
		private WebElement itiClick;
		
		@FindBy(id="logout")
		private WebElement logoutButton;
		
		public WebElement itineraryClick() {
			return itiClick;
		}
		
		public WebElement logout() {
			return logoutButton;
		}
		
		

	}

