package com.c3mm.client.view;

public class BookView
{
	public void printBookInfo(
			String title, 
			String author, 
			String pubDate, 
			String status, 
			String location,
			String isbn)
	{
		System.out.println(Columns.TITLE + ": " + title);
		System.out.println(Columns.AUTHOR + ": " + author);
		System.out.println(Columns.PUBDATE + ": " + pubDate);
		System.out.println(Columns.STATUS + ": " + status);
		System.out.println(Columns.LOCATION + ": " + location);
		System.out.println(Columns.ISBN + ": " + isbn);
		System.out.println();
	}
}
