package com.totalbeginner.springbootswaggerdemo.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.totalbeginner.springbootswaggerdemo.repository.UserRepository;

@RestController
@RequestMapping("/rest/users")
public class UserResource {
		
	private UserRepository userRepository;
	
	@Autowired
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private static List<User> users = new ArrayList<>();
	
	//GET OPERATIONS
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/id/{id}")
	public User getAUserById(@PathVariable("id") Integer id) {
		return userRepository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{username}")
	public User getByUserName(@PathVariable("username") String userName) {
		return userRepository.findByUserName(userName);
	}

	//CREATE OPERATIONS
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@PostMapping("/adduser")
	public String createUser(@RequestBody User user) {
		userRepository.save(user);
		return "Added user with username : "+user.getUserName();
	}	
	
	//DELETE OPRATIONS	  
	@RequestMapping(method=RequestMethod.GET, value="/delete/{userId}")
	public void delete(@PathVariable("userId")Integer userId) {
		User user = userRepository.findById(userId);
	  userRepository.delete(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteall")
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	// UPDATE
	@RequestMapping(method = RequestMethod.PUT, value = "/modify/{userId}")
	public User update(@PathVariable Integer userId, @RequestBody User user) {
		if (user == null) {
			throw new NotFoundException();
		}

		user.setUserName(user.getUserName());
		user.setSalary(user.getSalary());
		return userRepository.save(user);
	}
}
