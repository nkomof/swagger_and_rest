package com.totalbeginner.springbootswaggerdemo.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.totalbeginner.springbootswaggerdemo.repository.UserRepository;


public class UserResourceTest {
	
	@InjectMocks
	UserResource userResource;
	@Mock
	UserRepository userRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	final void testGetUserName() {
		Integer currentId = 120;
		User user = User.builder().id(++currentId).userName("Luke").salary(300L).build();		
		when(userRepository.findByUserName(anyString())).thenReturn(user);
		assertEquals("Luke", user.getUserName());
	}	
}
