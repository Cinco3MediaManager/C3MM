package com.c3mm.client.controller;

import com.c3mm.client.model.BookModel;
//import com.c3mm.client.view.BookView;
import com.c3mm.client.view.View;

public class BookController
{
	private BookModel book;
//	private BookView view;
	private View view;
	
//	public BookController(BookModel book, BookView view)
//	{
//		this.book = book;
//		this.view = view;
//	}

	public BookController(BookModel book, View view)
	{
		this.book = book;
		this.view = view;
	}
	
	public String getBookName()
	{
		return book.getTitle();
	}
	
	public String getBookAuthor()
	{
		return book.getAuthor();
	}
	
	public void setBookName(String name)
	{
		book.setTitle(name);
	}
	
	public void setBookAuthor(String author)
	{
		book.setAuthor(author);
	}
	
	public void updateView()
	{
		view.displayProperties(book.getProperties());
	}
}
