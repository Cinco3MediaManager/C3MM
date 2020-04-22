package com.c3mm.client.model;

import java.util.HashMap;

public class BookModel extends AbstractMediaModel
{
	private String isbn = null;
	private String author = null;
	private String pubDate; // publication date
	
	/**
	 * Initialize the model specific variables
	 */
	public BookModel()
	{
		super();
		this.isbn = "";
		this.author = "";
		this.pubDate = "";
	}
	
	public BookModel(int rec_id, String title, String author, int inStock, String pubDate, String isbn, String country,
			String type, String language)
	{
		super(rec_id, inStock, title, country, type, language);
		this.isbn = isbn;
		this.author = author;
		this.pubDate = pubDate;
	}
	
	public BookModel(String[] values)
	{
		super(Integer.parseInt(values[0]), Integer.parseInt(values[3]), values[1], values[6], values[7], values[8]);
		this.isbn = values[5];
		this.author = values[2];
		this.pubDate = values[4];
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
	
	public String getPubDate()
	{
		return pubDate;
	}
	
	public void setPubDate(String pubDate)
	{
		this.pubDate = pubDate;
	}
	
	public HashMap<String, String> getProperties()
	{
		HashMap<String, String> props = new HashMap<String, String>();
		props.put("id", String.valueOf( this.getRecId() ) );
		props.put("title", this.getTitle());
		props.put("author", this.getAuthor());
		props.put("stock", String.valueOf( this.getInStock() ) );
		props.put("date", this.getPubDate());
		props.put("isbn", this.getIsbn());
		props.put("country", this.getCountry());
		props.put("type", this.getType());
		props.put("lang", this.getLanguage());
		return props;
	}
}
