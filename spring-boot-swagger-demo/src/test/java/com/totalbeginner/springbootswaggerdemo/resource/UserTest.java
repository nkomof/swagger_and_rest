package com.totalbeginner.springbootswaggerdemo.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {	

	@Test
	public void testUserName() {
		User user = User.builder().salary(4500L).userName("nkomof").build();
		assertEquals("nkomof", user.getUserName());
	}

	@Test
	public void testUserSalary() {
		User user = User.builder().salary(4500L).userName("nkomof").build();
		Long expected = 4500L;
		assertEquals(expected, user.getSalary());
	}

}
