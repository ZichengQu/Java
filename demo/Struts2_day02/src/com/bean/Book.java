package com.bean;

public class Book {
	private String book_name;

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	@Override
	public String toString() {
		return "Book [book_name=" + book_name + "]";
	}
	
}
