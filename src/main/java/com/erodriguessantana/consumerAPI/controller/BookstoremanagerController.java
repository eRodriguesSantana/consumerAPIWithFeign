package com.erodriguessantana.consumerAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/")
	public List<Book> getAll() {
		return iBookstoremanager.getAll();		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable Long id) {
		Book book = iBookstoremanager.getBookByID(id);

		return book != null ? ResponseEntity.ok().body(book) : ResponseEntity.notFound().build();
	}

	@GetMapping("/bookwithauthor/{id}")
	public ResponseEntity<ResponseBookAuthor> getBookAndAuthorByID(@PathVariable Long id) {
		ResponseBookAuthor book = iBookstoremanager.getBookAndAuthorByID(id);

		return book != null ? ResponseEntity.ok().body(book) : ResponseEntity.notFound().build();
	}

	@PostMapping("/create")
	public ResponseEntity<Book> save(@RequestBody Book book) {
		Book saveBook = iBookstoremanager.save(book);
		return saveBook != null ? ResponseEntity.ok().body(saveBook) : ResponseEntity.notFound().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Book book, @PathVariable Long id) {
		Book saveBook = iBookstoremanager.update(book, id);

		return saveBook != null ? ResponseEntity.ok().body(saveBook) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Book deleteBook = iBookstoremanager.delete(id);

		return deleteBook != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
