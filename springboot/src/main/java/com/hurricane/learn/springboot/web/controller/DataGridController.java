package com.hurricane.learn.springboot.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hurricane.learn.springboot.web.entity.User;

@Controller
public class DataGridController {

	@RequestMapping("/dataGrid")
	public String dataGrid() {
		return "datagrid";
	}
	
	/**
	 * page:2
	 * rows:10
	 */
	@RequestMapping("/dataGridData")
	@ResponseBody
	public Object dataGrid(@RequestParam Map map) {
		Object object = map.get("page");
		Object object2 = map.get("rows");
		List<User> users = new ArrayList<User>();
		Integer page;
		if (!StringUtils.isEmpty(object)) {
			page = Integer.parseInt(object.toString());
		}else {
			page = 0;
		}
		Integer rows;
		if (!StringUtils.isEmpty(object2)) {
			rows = Integer.parseInt(object2.toString());
		}else {
			rows = 5;
		}
		for (int i = (page-1)*rows; i < page*rows; i++) {
			User user = new User();
			user.setId(i);
			user.setUsername("hurricane"+i);
			user.setPassword("password"+i);
			users.add(user);
		}
		
		return users;
	}
}
