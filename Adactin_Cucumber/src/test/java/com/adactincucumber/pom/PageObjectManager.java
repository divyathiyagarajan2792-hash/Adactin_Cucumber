package com.adactincucumber.pom;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private WebDriver driver;
	
	private LoginPage login;
	private SearchHotelPage searchhotel;
	private SelectHotelPage selecthotel;
	private BookHotelPage bookhotel;
	private BookingConfirmationPage bookconfirm;
	private BookingItineraryPage bookitinerary;
	
	public BookingItineraryPage getBookitinerary() {
		bookitinerary=new BookingItineraryPage(driver);
		return bookitinerary;
	}



	public BookingConfirmationPage getBookconfirm() {
		bookconfirm=new BookingConfirmationPage(driver);
		return bookconfirm;
	}



	public BookHotelPage getBookhotel() {
		bookhotel=new BookHotelPage(driver);
		return bookhotel;
	}



	public SelectHotelPage getSelecthotel() {
		selecthotel=new SelectHotelPage(driver);
		return selecthotel;
	}



	public SearchHotelPage getSearchhotel() {
		searchhotel=new SearchHotelPage(driver);
		return searchhotel;
	}



	public LoginPage getLoginPage() {
			login=new LoginPage(driver);
			return login;
	}
	
	

	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
}