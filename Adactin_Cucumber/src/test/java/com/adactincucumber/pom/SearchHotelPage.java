package com.adactincucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
	
	public WebDriver driver;
	
	public SearchHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="location")
	private WebElement location;
	
	@FindBy(name="hotels")
	private WebElement hotel;
	
	@FindBy(name="room_type")
	private WebElement roomType;
	
	@FindBy(name="room_nos")
	private WebElement roomno;
	
	@FindBy(id="datepick_in")
	private WebElement checkindate;
	
	@FindBy(id="datepick_out")
	private WebElement checkout;
	
	@FindBy(name="adult_room")
	private WebElement adultcount;
	
	@FindBy(id="child_room")
	private WebElement childcount;
	
	@FindBy(xpath="//input[@value=\"Search\"]")
	private WebElement search;
	
	@FindBy(xpath="((//tbody)[2]//td)[1]")
	private WebElement isHomePageDisplayed;
	
	@FindBy(tagName ="b")
	private WebElement isErrorMessageDisplayed;
	
	public WebElement getlocation() {
		return location;
		
	}
	
	public WebElement gethotels() {
		return hotel;
	}
	
	public WebElement getroomtype() {
		return roomType;
	}
	
	public WebElement getroomno() {
		return roomno;
	}
	
	public WebElement getCheckinDate() {
		return checkindate;
	}
	public WebElement getCheckOutDate() {
		return checkout;
	}
	
	public WebElement getadultcount () {
		return adultcount;
	}
	
	public WebElement getchildcount() {
		return childcount;
	}
	
	public WebElement getsearch() {
		return search;
	}
	
	public boolean isHomePageDisplayed() {
		return true;
	}

	public boolean isErrorMessageDisplayed() {
		return true;
	}
	
	
	}
	
	
	
	
	


