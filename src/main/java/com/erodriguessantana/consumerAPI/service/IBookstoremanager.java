package com.erodriguessantana.consumerAPI.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.erodriguessantana.consumerAPI.entity.Book;

@Configurable
@FeignClient(url = "http://localhost:8080/api/v1/books/", name = "bookstoremanager")
public interface IBookstoremanager {

	@GetMapping("/{id}")
	Book getBookByID(@PathVariable("id") Long id);
}
