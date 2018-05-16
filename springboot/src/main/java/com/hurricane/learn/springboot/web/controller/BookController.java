package com.hurricane.learn.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hurricane.learn.springboot.web.entity.Book;
import com.hurricane.learn.springboot.web.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/{id}")
	public Book findBook(@PathVariable("id") int id) {
		return bookService.findSingleBook(id);
	}
	
}
