package com.mondia.swagger.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mondia.swagger.entity.User;
import com.mondia.swagger.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {
		
	private UserRepository userRepository;
	
	@Autowired
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{userId}")
	public User getAUserById(@PathVariable("userId") Integer userId) {
		return userRepository.findOne(userId);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public Response createUser(@RequestBody @Valid User user) {
		userRepository.save(user);
		return Response.ok(user).status(201).build();
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/user/{userId}")
	public void delete(@PathVariable("userId")Integer userId) {
		User user = userRepository.findOne(userId);
	  userRepository.delete(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/all")
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}")
	public User update(@PathVariable Integer userId, @RequestBody @Valid User user) {
		return userRepository.save(user);
	}
}
