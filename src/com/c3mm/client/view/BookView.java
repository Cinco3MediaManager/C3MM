package com.c3mm.client.view;

public class BookView
{
	public void printBookInfo(
			String title, 
			String author,
			int inStock,
			String pubDate, 
			String isbn, 
			String country,
			String type,
			String language)
	{
		System.out.println(Columns.TITLE + ": " + title);
		System.out.println(Columns.AUTHOR + ": " + author);
		System.out.println(Columns.IN_STOCK + ": " + inStock);
		System.out.println(Columns.PUBDATE + ": " + pubDate);
		System.out.println(Columns.ISBN + ": " + isbn);
		System.out.println(Columns.COUNTRY + ": " + country);
		System.out.println(Columns.TYPE + ": " + type);
		System.out.println(Columns.LANG + ": " + language);
		System.out.println();
	}
}
