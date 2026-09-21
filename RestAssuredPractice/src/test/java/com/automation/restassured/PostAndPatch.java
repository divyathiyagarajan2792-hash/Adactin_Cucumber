package com.automation.restassured;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostAndPatch {
	@Test
	
	public void createAuthAndPatch() {
		
		 // STEP 1: GENERATE AUTH TOKEN (Required to authorize PUT)
		
		Map<String, String> authPayload=new HashMap<>();
		authPayload.put("username", "admin");
		authPayload.put("password", "password123");
		
		String tokenauth = given()
		.baseUri("https://restful-booker.herokuapp.com")
		.contentType(ContentType.JSON)
		.body(authPayload)
		
		.when()
		.post("/auth")
		
		.then()
		.statusCode(200)
		.extract().path("token");
		
		System.out.print("token generated is:"+ tokenauth);
		
		// STEP 2: POST REQUEST (CREATE NEW BOOKING)
		
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
        
       
	Object bookingid = given()
	.baseUri("https://restful-booker.herokuapp.com")
	.contentType(ContentType.JSON)
	.body(requestBody).log().all()
	
	.when()
	.post("/booking")
	
	.then()
	.statusCode(200)
	.extract().path("bookingid");
	
	// STEP 3: PATCH REQUEST (update firstname and lastname)
	Map<String,String> patchRequestBody=new HashMap<>();
	patchRequestBody.put("firstname", "Brown");
	patchRequestBody.put("lastname", "james");
	
	given()
	.baseUri("https://restful-booker.herokuapp.com")
	.contentType(ContentType.JSON)
	.header("Cookie", "token="+tokenauth)
	.body(patchRequestBody)
	
	.when()
	.patch("/booking/"+bookingid)
	
	.then()
	.statusCode(200)
	.log().all()
	.body("firstname", equalTo("Brown"))
	.body("lastname", equalTo("james"))
	.body("totalprice",equalTo(200))
	.body("additionalneeds", equalTo("Breakfast"));
	
	
	}
	
	}
	


