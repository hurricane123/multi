package com.hurricane.learn.springcloud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	public static boolean status = true;
	
	@RequestMapping("/status/{st}")
	public String updateStates(@PathVariable("st") boolean st) {
		String msg = "";
		status = st;
		return "服务器状态设置为："+status;
	}
}
