package com.totalbeginner.springbootswaggerdemo.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;


public class UserResourceTest {
	
	private static ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8088;
		responseSpecBuilder.expectStatusCode(200);
		responseSpecBuilder.expectContentType(MediaType.APPLICATION_JSON_VALUE);
	}
	
	@Test
	public void testGetAUserById(){
		given()
		.when()
		.get("/rest/users/id/{id}", 121)
		.then()
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build())
			.body("id", equalTo(121));
	}
	
	@Test
	public void testGetAll() {
		given()
		.when()
			.get("/rest/users/all")
		.then()
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build())
		.body("userName", hasItems("Sylvester"));
	}
	
	@Test
	public void testCreateUser() throws JSONException {
		User user = new User();
		user.setUserName("Jonas");
		user.setSalary(50l);
		user.setId(129);
		
		given()
			.body(user)
			.header("Content-Type", "application/json")
			.when()
			.post("/rest/users/adduser")
			.then()
			.spec(responseSpecBuilder.build());
	}
}
