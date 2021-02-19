package com.erodriguessantana.consumerAPI.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.erodriguessantana.consumerAPI.entity.Book;

@Component
@FeignClient(url = "localhost:8080", path = "/api/v1/books/", name = "bookstoremanager")
public interface IBookstoremanager {

	@GetMapping("/{id}")
	Book getBookByID(@PathVariable("id") Long id);
}
