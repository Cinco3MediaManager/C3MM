package com.c3mm.main;

import com.c3mm.client.controller.BookController;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.view.BookView;

public class BookTest
{
	/* Constants for testing for now */
	private final static String TABLE = "books";
	private final static String PARAM = "9781503290563";
	
	public static void main(String[] args)
	{
		C3Client client = new C3Client();
		
		BookModel model = client.getModel(TABLE, PARAM);
		
		
//		String[] values = client.getValues();
//		
//		BookModel model = new BookModel(values);
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
