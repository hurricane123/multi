package com.hurricane.learn.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/socket")
public class SocketController {

	@RequestMapping("")
	public String index() {
		return "socket";
	}
	
}
