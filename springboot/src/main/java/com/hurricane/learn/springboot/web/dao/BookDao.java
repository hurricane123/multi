package com.hurricane.learn.springboot.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hurricane.learn.springboot.web.entity.Book;

@Mapper
public interface BookDao {

	Book findById(int id);

}
