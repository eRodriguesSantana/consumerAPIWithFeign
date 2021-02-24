package com.erodriguessantana.consumerAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erodriguessantana.consumerAPI.entity.Book;
import com.erodriguessantana.consumerAPI.entity.ResponseBookAuthor;
import com.erodriguessantana.consumerAPI.service.IBookstoremanager;

@RestController
public class BookstoremanagerController {

	private IBookstoremanager iBookstoremanager;
	
	public BookstoremanagerController(IBookstoremanager iBookstoremanager) {
		this.iBookstoremanager = iBookstoremanager;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable Long id) {
		Book book = iBookstoremanager.getBookByID(id);
		
		return book != null ? ResponseEntity.ok().body(book) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("bookwithauthor/{id}")
	public ResponseEntity<ResponseBookAuthor> getBookAndAuthorByID(@PathVariable Long id) {
		ResponseBookAuthor book = iBookstoremanager.getBookAndAuthorByID(id);
		
		return book != null ? ResponseEntity.ok().body(book) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Book> save(@RequestBody Book book) {
		Book saveBook = iBookstoremanager.save(book);
		
		return ResponseEntity.ok().body(saveBook);
	}
}
