package com.hurricane.learn.springboot.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hurricane.learn.springboot.web.entity.User;

@RestController
public class MyController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	

}
