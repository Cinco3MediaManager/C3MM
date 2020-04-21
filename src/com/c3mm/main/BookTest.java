package com.c3mm.main;

import java.util.List;

import com.c3mm.client.controller.BookController;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.view.BookView;

public class BookTest
{
	/* Constants for testing for now */
	private final static String FIELD = "isbn";
	private final static String VALUE = "9781503290563";
	
	public static void main(String[] args)
	{
		C3Client client = new C3Client();
		List<BookModel> books = client.getAll(0);
		
		for (BookModel book : books)
		{
			System.out.println(book.getAuthor());
		}
		
		BookModel model = client.getModel(FIELD, VALUE);
		BookView view = new BookView();
		BookController controller = new BookController(model, view);
		
		System.out.println(controller.getBookAuthor());
		System.out.println(controller.getBookName());
		
		controller.updateView();
		
		controller.setBookAuthor("The Author");
		controller.setBookName("My Book");
		controller.updateView();
		
	}
}
