package com.c3mm.main;

import com.c3mm.client.controller.BookController;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.view.BookView;
import com.c3mm.server.dba.MediaDB;

public class BookTest
{
	public static void main(String[] args)
	{
		String isbn = "1234567890";
		BookModel book = MediaDB.getBook(isbn);
		BookView view = new BookView();
		BookController controller = new BookController(book, view);
		System.out.println(controller.getBookAuthor());
		System.out.println(controller.getBookName());
		
		controller.updateView();
		
		controller.setBookAuthor("Chechi");
		controller.setBookName("My Book");
		controller.updateView();
		
		C3Client.runClient("localhost", 4000);
		String[] values = C3Client.getValues();
		
		for (String s : values)
		{
			System.out.println(s);
		}
	}
}
