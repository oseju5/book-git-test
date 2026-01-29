package com.yonsai.book.dto;

import java.math.BigDecimal;



public class BookDTO {

	private Long id;
	private String title;
	private String author;
	private BigDecimal price;
	
	public BookDTO() {
	}
	
	public BookDTO(Long id, String title, String author, BigDecimal price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	
	
}
