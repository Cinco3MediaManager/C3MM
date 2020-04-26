package com.c3mm.client.model;

import java.util.HashMap;

/**
 * Books Entity Definition in DB
 *  book_id  INTEGER       PRIMARY KEY AUTOINCREMENT
 *                         UNIQUE
 *                         NOT NULL,
 *  title    VARCHAR (100) NOT NULL,
 *  author   VARCHAR (30)  NOT NULL,
 *  in_stock INTEGER (2)   NOT NULL,
 *  pub_date DATE (8)      NOT NULL,
 *  isbn     TEXT (13)     UNIQUE,
 *  country  VARCHAR (20),
 *  type     VARCHAR       NOT NULL
 *                         CONSTRAINT chk_type CHECK (type IN ('print', 'cd', 'e-reader', 'audio-stream') ),
 *  language VARCHAR (20) 
 *  
 * @author power-serge
 */
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
		props.put(Props.ID, String.valueOf( this.getRecId() ) );
		props.put(Props.TITLE, this.getTitle());
		props.put(Props.AUTHOR, this.getAuthor());
		props.put(Props.STOCK, String.valueOf( this.getInStock() ) );
		props.put(Props.DATE, this.getPubDate());
		props.put(Props.ISBN, this.getIsbn());
		props.put(Props.COUNTRY, this.getCountry());
		props.put(Props.TYPE, this.getType());
		props.put(Props.LANG, this.getLanguage());
		return props;
	}
}
