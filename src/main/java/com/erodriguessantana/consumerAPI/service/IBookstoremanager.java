package com.erodriguessantana.consumerAPI.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erodriguessantana.consumerAPI.entity.Book;
import com.erodriguessantana.consumerAPI.entity.ResponseBookAuthor;

@Component
@FeignClient(url = "localhost:8080", path = "/api/v1/books/", name = "bookstoremanager")
public interface IBookstoremanager {

	@GetMapping("/{id}")
	Book getBookByID(@PathVariable("id") Long id);
	
	@GetMapping("/bookwithauthor/{id}")
	ResponseBookAuthor getBookAndAuthorByID(@PathVariable("id") Long id);
	
	@PostMapping("/create")
	Book save(@RequestBody Book book);
	
	@PutMapping("/update/{id}")
	Book update(@RequestBody Book book, @PathVariable Long id);
	
	@DeleteMapping("/delete/{id}")
	Book delete(@PathVariable Long id);
}
