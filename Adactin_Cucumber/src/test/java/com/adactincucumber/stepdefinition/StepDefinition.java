package com.adactincucumber.stepdefinition;

import com.adactincucumber.base.BaseClass;
import com.adactincucumber.configreader.ConfigReader;
import com.adactincucumber.pom.BookHotelPage;
import com.adactincucumber.pom.BookingConfirmationPage;
import com.adactincucumber.pom.BookingItineraryPage;
import com.adactincucumber.pom.LoginPage;
import com.adactincucumber.pom.PageObjectManager;
import com.adactincucumber.pom.SearchHotelPage;
import com.adactincucumber.pom.SelectHotelPage;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinition extends BaseClass{

	
	public static PageObjectManager pom ;
	ConfigReader config;
	
@Given("user Launches The Application")
public void user_launches_the_application() throws InterruptedException, IOException {

	config = new ConfigReader();
	String url = config.getProperty("url");
	get(url);
	pom=new PageObjectManager(driver);
	
	}
@When("user Enters {string} In Username Field")
public void user_enters_in_username_field(String username) {
inputValue(pom.getLoginPage().getUserName(), username);


}
@When("user Enters {string} In Password Field")
public void user_enters_in_password_field(String password) {
	 inputValue(pom.getLoginPage().getPassword(), password);
	
}
@When("user clicks the Login button")
public void user_clicks_the_login_button() {
	 	click(pom.getLoginPage().getLoginButton());
}
/*@Then("user should be logged in successfully")
public void user_should_be_logged_in_successfully() {
	waitForElement(pom.getSearchhotel().getlocation());
	Assert.assertEquals("Welcome to Adactin Group of Hotels", pom.getSearchhotel().getsuccessmessage().getText());
}*/

@Then("login result should be {string}")
public void login_result_should_be(String expectedResult) {
	
	if(expectedResult.contains("success")) {
		waitForElement(pom.getSearchhotel().getlocation());
		Assert.assertTrue(pom.getSearchhotel().isHomePageDisplayed());
	} else {
	    Assert.assertTrue(pom.getSearchhotel().isErrorMessageDisplayed());
	}
}
@Then("user should be navigated to the Search Hotel page")
public void user_should_be_navigated_to_the_search_hotel_page() {
}

@When("user Selects the Location In Location Field")
public void user_selects_the_location_in_location_field() {
   selectRandomOption(pom.getSearchhotel().getlocation(), "index");
		   
}

@When("user Select The Hotel In Hotel Field")
public void user_select_the_hotel_in_hotel_field() {
    //selectRandomOption(sh.gethotels(), "index");
	selectRandomOption(pom.getSearchhotel().gethotels(), "index");
}

@When("user Select The Room Type In RoomType Field")
public void user_select_the_room_type_in_room_type_field() {
	selectRandomOption(pom.getSearchhotel().getroomtype(), "index");
}
@When("user Select The No. Of Rooms In Room Field")
public void user_select_the_no_of_rooms_in_room_field() {
	selectRandomOption(pom.getSearchhotel().getroomno(), "value");
}
@When("user Enters The Date In check In Date Field")
public void user_enters_the_date_in_check_in_date_field() {
	pom.getSearchhotel().getCheckinDate().clear();
	inputValue(pom.getSearchhotel().getCheckinDate(),"04/08/2026");
}
@When("user Enters The Date In check Out Date Field")
public void user_enters_the_date_in_check_out_date_field() {
    pom.getSearchhotel().getCheckOutDate().clear();
    inputValue(pom.getSearchhotel().getCheckOutDate(), "06/08/2026");
}
@When("user Select Adults per Room In Adults Per Room Field")
public void user_select_adults_per_room_in_adults_per_room_field() {
   select(pom.getSearchhotel().getadultcount(),"index","2");
}
@When("user Select Children Per Room In Children Per Room Field")
public void user_select_children_per_room_in_children_per_room_field() {
    select(pom.getSearchhotel().getchildcount(),"visibletext","1 - One" );
}
@Then("user Click On The Search Button And It Navigates To The Select Hotel Page")
public void user_click_on_the_search_button_and_it_navigates_to_the_select_hotel_page() {
    click(pom.getSearchhotel().getsearch());
}

@When("user Click The Radio Button To Select The Hotel")
public void user_click_the_radio_button_to_select_the_hotel() {
    click(pom.getSelecthotel().selectHotel());
}
@Then("user Click On The Continue Button And It Navigates To The Booking Page")
public void user_click_on_the_continue_button_and_it_navigates_to_the_booking_page() {
   click(pom.getSelecthotel().clickContinue());
}

@When("user enters the following booking details")
public void user_enters_the_following_booking_details(DataTable dataTable) {
	Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
	  inputValue(pom.getBookhotel().getFirstName(),data.get("firstname"));
	  inputValue(pom.getBookhotel().getlastName(), data.get("lastname"));
	  inputValue(pom.getBookhotel().getAddress(),data.get("address"));
	  inputValue(pom.getBookhotel().getccnum(),data.get("cardno"));
	  select(pom.getBookhotel().getccType(),"visibletext",data.get("cardtype"));
	  select(pom.getBookhotel().getccExpMonth(), "visibletext",data.get("month"));
	  select(pom.getBookhotel().getccExpYear(),"visibletext",data.get("year"));
	  inputValue(pom.getBookhotel().getccCCV(),data.get("cvv"));
}


@Then("user Click On The Book Now Button And It Navigates To The Booking Confirmation Page")
public void user_click_on_the_book_now_button_and_it_navigates_to_the_booking_confirmation_page() {
    click(pom.getBookhotel().getbookingconfirm());
    waitForElement(pom.getBookconfirm().confirmClick());
}


@Then("user Click On The My Itinerary Button And It Navigates To The Book Itinerary Page")
public void user_click_on_the_my_itinerary_button_and_it_navigates_to_the_book_itinerary_page() {
	 waitForElement(pom.getBookconfirm().confirmClick());
    click(pom.getBookconfirm().confirmClick());
    waitForElement(pom.getBookitinerary().itineraryClick());
}

@When("user Click On The Cancel Button In Cancel Field")
public void user_click_on_the_cancel_button_in_cancel_field() {
    click(pom.getBookitinerary().itineraryClick());
}
@Then("user Click Ok Button on Alert And It Navigates To The Book Itinerary Page")
public void user_click_ok_button_on_alert_and_it_navigates_to_the_book_itinerary_page() {
    acceptAlert();
}


@Then("user Click On The Logout Button And It Navigates To The Logout Page")
public void user_click_on_the_logout_button_and_it_navigates_to_the_logout_page() {
   click(pom.getBookitinerary().logout());
}


}


