package com.mondia.swagger.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.mondia.swagger.entity.User;

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
                .header("Content-Type", "application/json")
		.when()
                .get("/users/user/{id}", 123)
		.then()
                .assertThat().statusCode(HttpStatus.OK.value()).body("id", equalTo(123))
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build())
                .body("id", equalTo(123));
	}
	
	@Test
	public void testGetAll() {
		given()
		.when()
                .get("/users/all")
		.then()
                .assertThat().statusCode(HttpStatus.OK.value()).body("userName", hasItems("Sylvester Ndaba"))
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build())
                .body("userName", hasItems("Sylvester Ndaba"));
	}
	
	@Test
	public void testCreateUser() throws JSONException {
		final User user = new User();
        user.setUserName("Masood Gool");
        user.setSalary(500l);
        user.setId(123);
		
		given()
			.body(user)
			.header("Content-Type", "application/json")
			.when()
                .post("/users/user")
			.then()
                .assertThat().statusCode(200)
			.spec(responseSpecBuilder.build());
	}

	@Test
    public void testDeleteAll() {
		given()
		.header("Content-Type", "application/json")
		.when()
                .delete("/users/all")
		.then()
                .assertThat().statusCode(HttpStatus.OK.value())
			.log()
			.ifValidationFails()
			.spec(responseSpecBuilder.build());
	}

	@Test
	public void testModifyUser() {
		final User user = new User();
        user.setUserName("Masood Gool jnr.");
        user.setSalary(550l);
		user.setId(123);
		
		given()
			.body(user)
			.header("Content-Type", "application/json")
			.when()
                .put("/users/user/{userId}", 123)
			.then()
                .assertThat().statusCode(HttpStatus.OK.value()).body("id", equalTo(123))
			.spec(responseSpecBuilder.build());
	}
}
