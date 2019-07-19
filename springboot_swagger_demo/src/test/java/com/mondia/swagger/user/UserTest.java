package com.mondia.swagger.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mondia.swagger.entity.User;

public class UserTest {

	@Test
	public void testUserName() {
		final User user = User.builder().id(1).salary(4500L).userName("nkomof").build();
		assertEquals("nkomof", user.getUserName());
	}

	@Test
	public void testUserSalary() {
		final User user = User.builder().id(1).salary(4500L).userName("nkomof").build();
		final Long expected = 4500L;
		assertEquals(expected, user.getSalary());
	}

    @Test
    public void testUserId() {
        final User user = User.builder().id(1).salary(4500L).userName("nkomof").build();
        final Integer expected = 1;
        assertEquals(expected, user.getId());
    }
}
