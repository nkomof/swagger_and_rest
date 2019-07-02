package com.totalbeginner.springbootswaggerdemo.resource;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest
public class UserResourceTest {
	
	@Autowired
	private MockMvc mockMvc;	
	
	@InjectMocks
	private UserResource users = new UserResource();
	
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

	
	@Test
	public void testGetAllUsers() throws Exception {
		mockMvc.perform(get("/rest/user/json")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("[{\"userName\":\"Aluwani\",\"salary\":4500},{\"userName\":\"Luke\",\"salary\":3500}]")));
	}
	
	@Test
	public void testGetAUser() throws Exception {
		mockMvc.perform(get("/rest/user/Msizi")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("{\"userName\":\"Msizi\",\"salary\":2500}")));

	}

}
