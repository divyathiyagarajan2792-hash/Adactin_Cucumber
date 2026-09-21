package com.automation.restassured;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class TokenAndDelete {
	@Test
	public void postAuthDelete() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		//post method to get token
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.when()
		.post("/auth")
		.then()
		.statusCode(200).extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		Object token = jsonPath.get("token");
		
		System.out.print("token is"+token);
		
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
			
			System.out.print("Booking id is:"+bookingid);
			
			//Delete
			
			given()
			.pathParam("bookingid", bookingid)
			.header("cookie","token="+token)
			//.cookie("token", token) // REST Assured sets 'Cookie: token=<value>' for you
			.when().delete("/booking/{bookingid}")
			.then()
			.statusCode(201);
		
		
		
	}

}
