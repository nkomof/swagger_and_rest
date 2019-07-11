package com.totalbeginner.springbootswaggerdemo.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.totalbeginner.springbootswaggerdemo.resource.User;

public class UserTest {

	@Test
	public void testUserName() {
		User user = User.builder().id(1).salary(4500L).userName("nkomof").build();
		assertEquals("nkomof", user.getUserName());
	}

	@Test
	public void testUserSalary() {
		User user = User.builder().id(1).salary(4500L).userName("nkomof").build();
		Long expected = 4500L;
		assertEquals(expected, user.getSalary());
	}
}
