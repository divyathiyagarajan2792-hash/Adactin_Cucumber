package com.adactincucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage {

public WebDriver driver;
	
	public BookHotelPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="first_name")
	private WebElement enterFirstname;
	
	public WebElement getFirstName() {
		return enterFirstname;
	}
	
	@FindBy(name="last_name")
	private WebElement enterlastname;
	
	public WebElement getlastName() {
		return enterlastname;
	}
	
	@FindBy(name="address")
	private WebElement enterAddress;
	
	public WebElement getAddress() {
		return enterAddress;
	}
	
	@FindBy(name="cc_num")
	private WebElement enterccnum;
	
	public WebElement getccnum() {
		return enterccnum;
	}
	
	@FindBy(name="cc_type")
	private WebElement enterccType;
	
	public WebElement getccType() {
		return enterccType;
	}
	
	@FindBy(id="cc_exp_month")
	private WebElement enterccexpmonth;
	
	public WebElement getccExpMonth() {
		return enterccexpmonth;
	}
	
	@FindBy(name="cc_exp_year")
	private WebElement enterccexpYear;
	
	public WebElement getccExpYear() {
		return enterccexpYear;
	}
	
	@FindBy(name="cc_cvv")
	private WebElement enterCCV;
	
	public WebElement getccCCV() {
		return enterCCV;
	}
	
	@FindBy(id="book_now")
	private WebElement confirmbooking;
	
	public WebElement getbookingconfirm() {
		return confirmbooking;
	}

}


