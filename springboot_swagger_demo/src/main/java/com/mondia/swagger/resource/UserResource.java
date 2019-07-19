package com.mondia.swagger.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mondia.swagger.entity.User;
import com.mondia.swagger.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Handles requests for the user operations.
 */

@RestController
@RequestMapping("/users")
@Api(value = "users resource API", produces = MediaType.APPLICATION_JSON)
public class UserResource {
		
	private UserRepository userRepository;
	
	@Autowired
	public UserResource(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    /**
     * Return all users.
     */
	@RequestMapping(method=RequestMethod.GET, value="/all")
    @ApiOperation("Gets all users")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserResource.class) })
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
    /**
     * Selects a user based on a user id.
     */
	@RequestMapping(method=RequestMethod.GET, value="/user/{userId}")
    @ApiOperation("Gets a user with a specific id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserResource.class) })
    public User getAUserById(@ApiParam(value = "Id of the user", required = true) @PathVariable("userId") final Integer userId) {
		return userRepository.findOne(userId);
	}

    /**
     * Creates a new user.
     */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@RequestMapping(method=RequestMethod.POST, value="/user")
    @ApiOperation("Creates a new user")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserResource.class) })
    public ResponseEntity<Void> createUser(@RequestBody @Valid final User user, final UriComponentsBuilder builder) {
        userRepository.save(user);
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{userId}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Deletes a user based on an id.
     */
	@RequestMapping(method=RequestMethod.DELETE, value="/user/{userId}")
    @ApiOperation("Deletes a user with a specific id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserResource.class) })
    public void delete(@ApiParam(value = "Id of the user", required = true) @PathVariable("userId") final Integer userId) {
		final User user = userRepository.findOne(userId);
	  userRepository.delete(user);
	}

    /**
     * Deletes all users.
     */
	@RequestMapping(method=RequestMethod.DELETE, value="/all")
    @ApiOperation("Deletes all users")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserResource.class) })
	public void deleteAll() {
		userRepository.deleteAll();
	}

    /**
     * Updates a user based on a user id.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}")
    @ApiOperation("Updates existing user or creates one if does not exists")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = UserResource.class) })
    public ResponseEntity<User> update(@ApiParam(value = "Id of the user", required = true) @PathVariable final Integer userId,
            @RequestBody @Valid final User user) {
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
