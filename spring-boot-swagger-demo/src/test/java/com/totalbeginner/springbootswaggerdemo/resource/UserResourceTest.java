package com.totalbeginner.springbootswaggerdemo.resource;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;


@RunWith(SpringRunner.class)
public class UserResourceTest {
	
    @Before
    public void init() throws Exception {
        User user = User.builder().id(0).userName("Aluwani").salary(4500l).build();
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8088;
    }
    //localhost:8088/rest/users/all --- GET
    //localhost:8088/rest/users/delete/126  ---DELETE
    //localhost:8088/rest/users/user/Tiisetso ---GET
    //localhost:8088/rest/users/adduser  ---  POST
    
    @Test
    @Ignore
    public void testGetByUserName() {
		get("/rest/users/user/Tiisetso").then().body("userName", equalTo("Tiisetso"))
		.body("salary", equalTo("100")).body("id", equalTo(126));    	
    }
    
    @Test
    public void testGetAUser() throws Exception {
        String result = "{\"userName\":\"Msizi\",\"salary\":2500,\"id\":121}";
        JSONAssert.assertEquals("{\"userName\":\"Msizi\",\"salary\":2500,\"id\":121}", result, true);
    }
	
	@Test
	public void testGetAllUsers() throws Exception {
	    String result = "[{\"userName\":\"Sylvester\",\"salary\":4500,\"id\":122},{\"userName\":\"Luke\",\"salary\":3500,\"id\":123}]";
	    JSONAssert.assertEquals("[{\"userName\":\"Sylvester\",\"salary\":4500,\"id\":122},{\"userName\":\"Luke\",\"salary\":3500,\"id\":123}]", result, true);
	}
	

}
