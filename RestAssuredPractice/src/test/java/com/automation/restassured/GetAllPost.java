package com.automation.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllPost {

	@Test
	public void allPost() {
		/*given()
		.baseUri("https://jsonplaceholder.typicode.com")
		
		.when()
		.get("/posts")
		
		.then()
		.statusCode(200)
		.body("size()", greaterThan(0))
		.log().all();*/
		
		given().baseUri("https://restful-booker.herokuapp.com")
			.log().all()
		
		.when()
			.get("/booking")
		
		.then()
			.log().all()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.body("size()", greaterThan(0))
			.time(lessThan(5000L));
	}
	
	
	
}
