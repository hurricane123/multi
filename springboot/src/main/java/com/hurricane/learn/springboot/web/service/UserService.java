package com.hurricane.learn.springboot.web.service;

import java.util.List;

import com.hurricane.learn.springboot.web.entity.User;

public interface UserService {
	
	Object getUserById(int... id);

	Object getUserByPage(int page, int size);

	List<User> getUserByRange(int begin, int size);
	
}
