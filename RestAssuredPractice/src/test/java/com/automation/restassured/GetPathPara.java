package com.automation.restassured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class GetPathPara {
	
	@Test
	public void pathPara() {
		
		/*given()
		.baseUri("https://jsonplaceholder.typicode.com")
		.pathParam("id", 1)
		
		.when()
		.get("/posts/{id}")
		
		.then()
		.statusCode(200)
		.log().all();*/
		
		// Path params — /booking/{id}
		given()
		.baseUri("https://restful-booker.herokuapp.com")
		.pathParam("id",2)
		
		.when()
		.get("/booking/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
