package com.erodriguessantana.consumerAPI.entity;

public class Book {

	private Long id;
	private String name;
	private Integer pages;
	private Integer chapters;
	private String isbn;
	private String publisherName;
	private Long idAuthor;
		
	public Book() {
	}
	
	public Book(Long id, String name, Integer pages, Integer chapters, String isbn, String publisherName) {
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.chapters = chapters;
		this.isbn = isbn;
		this.publisherName = publisherName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getChapters() {
		return chapters;
	}
	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

}
