package com.hurricane.learn.springboot.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hurricane.learn.springboot.web.entity.User;

@Mapper
public interface UserDao {
	User getUserById(int id);

	int getUserTotals();

	List<User> getUserByPage(Map<String, Integer> params);
}
