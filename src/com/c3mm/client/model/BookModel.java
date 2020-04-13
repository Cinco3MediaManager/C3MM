package com.c3mm.client.model;

public class BookModel extends AbstractMediaModel
{
	private String isbn = null;
	private String author = null;
	
	public BookModel(int rec_id, String status, String title, String location, String pubDate,
			String isbn, String author)
	{
		super(rec_id, status, title, location, pubDate);
		this.isbn = isbn;
		this.author = author;
	}
	
	public String getIsbn()
	{
		return isbn;
	}
	
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
}
