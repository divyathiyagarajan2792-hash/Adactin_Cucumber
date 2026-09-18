package com.automation.restassured;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Postdata {
	
	@Test
	public void createData() {
		
		Map<String, String>bookingDates=new HashMap<>();
		bookingDates.put("checkin", "2026-09-18");
        bookingDates.put("checkout", "2026-09-18");
		
		Map<String,Object>requestBody=new HashMap<>();
		requestBody.put("firstname","Andrew");
		requestBody.put("lastname", "jackson");
		requestBody.put("totalprice", 200);
		requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", bookingDates); // Pass the nested map here
        requestBody.put("additionalneeds", "Breakfast");
        
       
	given()
	.baseUri("https://restful-booker.herokuapp.com")
	.contentType(ContentType.JSON)
	.body(requestBody).log().all()
	
	.when()
	.post("/booking")
	
	.then()
	.statusCode(200)
	.body("bookingid",notNullValue())
	.body("booking.firstname", equalTo("Andrew"))
	.body("booking.lastname", equalTo("jackson"))
	.body("booking.totalprice", equalTo(200))
    .body("booking.depositpaid", equalTo(true))
    .body("booking.bookingdates.checkin", equalTo("2026-09-18"))
    .body("booking.bookingdates.checkout", equalTo("2026-09-18"))
    .body("booking.additionalneeds", equalTo("Breakfast"))
    .log().all();
	
	}
	

}
