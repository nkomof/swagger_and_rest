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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	@InjectMocks
	private HelloResource helloResource;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
	}

	@Test
	public void testTesting() throws Exception {
		mockMvc.perform(get("/rest/hello/test")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("testing hello")));
	}
	
	@Test
	public void tesHelloWorld() throws Exception {
		mockMvc.perform(get("/rest/hello/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello world of Java and spring boot"));
	}

}
