package com.hurricane.learn.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurricane.learn.springboot.web.dao.BookDao;
import com.hurricane.learn.springboot.web.entity.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book findSingleBook(int id) {
		return bookDao.findById(id);
	}

}
