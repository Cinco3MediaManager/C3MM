package com.c3mm.client.model;

public class Props
{
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String STOCK = "stock";
	public static final String DATE = "date";
	public static final String ISBN = "isbn";
	public static final String COUNTRY = "country";
	public static final String TYPE = "type";
	public static final String LANG = "lang";
	public static final String YEAR = "year";
	public static final String ARTIST = "artist";
	public static final String DIRECTOR = "director";
	
	public static class Comms
	{
		/**
		 * String delimiter to break the server's response into an array
		 */
		public static final String DELIM = ";";
		
		public static final String FOUND = "found";
		public static final String NOT_FOUND = "no results found";
		public static final String DONE = "done.";
		
		public static final String SEL = "s";
		public static final String UPD = "u";
		public static final String INS = "i";
		
		public static final String BOOKS_MSG = SEL + DELIM + Table.BOOKS + DELIM; 
		public static final String BOOKS_ALL = SEL + Comms.DELIM + Table.BOOKS;
		
		public static final String CDS_MSG = SEL + DELIM + Table.CDS + DELIM; 
		public static final String CDS_ALL = SEL + Comms.DELIM + Table.CDS; 
	}
	
	class Table
	{
		public static final String BOOKS = "books";
		public static final String CDS = "cds";
		public static final String MOVIES = "movies";
	}
}

