package com.hurricane.learn.springcloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hurricane.learn.springcloud.entity.Person;
import com.hurricane.learn.springcloud.entity.User;

@RestController
public class UserController {

	@GetMapping(value="/getUser")
	public User getUser(HttpServletRequest request) {
		User user = new User();
		user.setId(0);
		user.setUsername("hurricane");
		user.setPassword(request.getSession().getId());
		user.setDesc(request.getRequestURL().toString());
		return user;
	}
	
	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPerson(@PathVariable("personId") Integer personId) {
		Person person = new Person(personId, "Crazyit2", 330);
		return person;
	}	
}
