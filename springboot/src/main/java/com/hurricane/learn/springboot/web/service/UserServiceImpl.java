package com.hurricane.learn.springboot.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hurricane.learn.springboot.web.dao.UserDao;
import com.hurricane.learn.springboot.web.entity.DataGridData;
import com.hurricane.learn.springboot.web.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public Object getUserById(int... id) {
		List<User> users = new ArrayList<User>();
		for (int i : id) {
			User user = userDao.getUserById(i);
			if (user != null) {
				users.add(user);
			}
		}
		return users;
	}
	
	
	@Override
	public Object getUserByPage(int page,int size) {
//		{"total":486,"rows":[{"age":10,"email":"lqi@sina.com","id":1,"name":"张三","sex":"男"}]}  
		page = page<0?0:page;
		size = size<=0?5:size;
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("begin", (page-1)*size);
		params.put("size", size);
		List<User> users = userDao.getUserByPage(params);
		int total = userDao.getUserTotals();
		DataGridData gridData = new DataGridData();
		gridData.setRows(users);
		gridData.setTotal(total);
		return gridData;
	}
	
	@Override
	public List<User> getUserByRange(int begin,int size) {
		begin = begin<0?0:begin;
		size = size<=0?5:size;
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("begin", begin);
		params.put("size", size);
		List<User> resultList = userDao.getUserByPage(params);
		return resultList;
	}

}
