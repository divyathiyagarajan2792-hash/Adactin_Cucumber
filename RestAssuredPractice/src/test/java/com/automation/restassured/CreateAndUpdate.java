package com.automation.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateAndUpdate {
	@Test
	public void postAndPut() {
		 // STEP 1: GENERATE AUTH TOKEN (Required to authorize PUT)
		
		Map<String, Object> authPayload=new HashMap<>();
		authPayload.put("username", "admin");
		authPayload.put("password", "password123");
		
		String tokenValue = given()
		.baseUri("https://restful-booker.herokuapp.com")
		.contentType(ContentType.JSON)
		.body(authPayload)
		
		.when()
		.post("/auth")
	
		.then()
		.statusCode(200)
		.extract().path("token");
		
		System.out.println("generated token:"+tokenValue);
		
		// STEP 2: POST REQUEST (CREATE NEW BOOKING)
		Map<String, String> postDates = new HashMap<>();
        postDates.put("checkin", "2026-09-18");
        postDates.put("checkout", "2026-09-18");

        Map<String, Object> postBody = new HashMap<>();
        postBody.put("firstname", "jackson");
        postBody.put("lastname", "Andrew");
        postBody.put("totalprice", 200);
        postBody.put("depositpaid", true);
        postBody.put("bookingdates", postDates);
        postBody.put("additionalneeds", "Breakfast");
        
        Object bookingId = given()
		.baseUri("https://restful-booker.herokuapp.com")
		.contentType(ContentType.JSON)
		.body(postBody)
		
		.when()
		.post("/booking")
		
		.then()
		.statusCode(200)
		.extract().path("bookingid");
        
        System.out.println("booking id:"+bookingId);
        
        // STEP 3: PUT REQUEST (UPDATE THE SAME BOOKING)
        
        Map<String, String> putDates = new HashMap<>();
        putDates.put("checkin", "2026-09-18");
        putDates.put("checkout", "2026-09-18");

        Map<String, Object> putBody = new HashMap<>();
        putBody.put("firstname", "Michel");
        putBody.put("lastname", "Andrew");
        putBody.put("totalprice", 199);
        putBody.put("depositpaid", true);
        putBody.put("bookingdates", putDates);
        putBody.put("additionalneeds", "lunch");
        
        given()
        .baseUri("https://restful-booker.herokuapp.com")
        .contentType(ContentType.JSON)
        .header("Cookie", "token="+ tokenValue)
        .body(putBody)
        
        .when()
        .put("/booking/"+bookingId)
        
        .then()
        .log().all()
        .statusCode(200)
        .body("firstname", equalTo("Michel"))
        .body("totalprice", equalTo(199))
        .body("additionalneeds", equalTo("lunch"));
	
	
	
	
	}
	

}
