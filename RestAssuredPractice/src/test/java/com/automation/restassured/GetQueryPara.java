package com.automation.restassured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class GetQueryPara {
	
	@Test
	public void queryPara() {
		// Used for filtering, sent as key value pair
	/*	given()
		.baseUri("https://jsonplaceholder.typicode.com")
		.queryParam("userId", 1)
		
		.when()
		.get("/posts")
		
		.then()
		.statusCode(200)
		.body("userId", everyItem(equalTo(1)));*/
	
	// Query params — /booking?firstname=Jim&lastname=Brown
	given()
		.baseUri("https://restful-booker.herokuapp.com")
		.queryParam("firstname","Eric")
		.queryParam("lastname", "Wilson")
		.log().all()
		
		.when()
		.get("/booking/2")
		
		.then()
		.statusCode(200).log().all()
		.body("totalprice", equalTo(150));
	}

}
