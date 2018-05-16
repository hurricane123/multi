package com.hurricane.learn.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyController2 {

	@RequestMapping("/hello2")
	public String sayHello() {
		return "sss";
	}
	
	@RequestMapping("/hello3")
	public String sayHello3() {
		return "sss3";
	}
}
