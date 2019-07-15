package com.totalbeginner.springbootswaggerdemo.resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/rest/hello")
public class HelloResource {
	
	@RequestMapping("/test")
	public String test() {
		return "testing hello";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello world of Java and spring boot";
	}
	
	@PostMapping("/post")
	public String helloPost(@RequestBody final String hello) {
		return hello;
	}
	
	@PutMapping("/put")
	public String helloPut(@RequestBody final String hello) {
		return hello;
	}
}
