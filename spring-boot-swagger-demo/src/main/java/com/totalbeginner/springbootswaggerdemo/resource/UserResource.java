package com.totalbeginner.springbootswaggerdemo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
	
	@GetMapping
	public List<User> getUsers() {
		
		return Arrays.asList(
				new User("Aluwani", 4500L),
				new User("Luke", 3500L)
				);
	}
	
	@GetMapping("/{userName}")
	public User getuser(@PathVariable ("userName") final String userName) {
		return new User(userName, 2500L);
	}
}
