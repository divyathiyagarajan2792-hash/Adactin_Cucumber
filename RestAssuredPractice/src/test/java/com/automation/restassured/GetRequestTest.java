package com.automation.restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class GetRequestTest {
  @Test
  public void getPost()  {
	  
	  //given()-prepare the request
	  //When()-send the request
	  //then()-validate the request
	  
	  given()
	  .baseUri("https://jsonplaceholder.typicode.com")
	  
	 .when().get("/posts/1")
	 
	 .then()
	  .statusCode(200)
	  .body("userId",equalTo(1))
	  .log().all();
  }

  
  



  }

