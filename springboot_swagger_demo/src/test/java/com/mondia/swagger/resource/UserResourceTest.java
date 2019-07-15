package com.mondia.swagger.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.MediaType;

import com.mondia.swagger.entity.User;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;


public class UserResourceTest {
	
	private static ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
	@LocalServerPort
	private int port;

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
		.get("/users/user/{id}", 121)
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
			.get("/users/all")
		.then()
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build())
		.body("userName", hasItems("Sylvester"));
	}
	
	@Test
	public void testCreateUser() throws JSONException {
		User user = new User();
		user.setUserName("Helen Major");
		user.setSalary(50l);
		user.setId(128);
		
		given()
			.body(user)
			.header("Content-Type", "application/json")
			.when()
			.post("/users/user")
			.then()
			.spec(responseSpecBuilder.build());
	}
/*	
	@Test
	public void testDeleteUser() {
		given()
		.header("Content-Type", "application/json")
		.when()
		.get("/rest/users/delete/{id}", 127)
		.then()
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build());
	}
*/	
	@Test
	public void testModifyUser() {
		User user = new User();
		user.setUserName("Sylvester Ndaba");
		user.setSalary(400l);
		user.setId(123);
		
		given()
			.body(user)
			.header("Content-Type", "application/json")
			.when()
			.put("/users/user/{userId}", 123)
			.then()
			.spec(responseSpecBuilder.build());
	}
}
