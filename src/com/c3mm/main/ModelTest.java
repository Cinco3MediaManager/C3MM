package com.c3mm.main;

import java.util.List;

import com.c3mm.client.controller.BookController;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.view.BookView;

public class ModelTest
{
	/* Constants for testing for now */
	private final static String FIELD = "isbn";
	private final static String VALUE = "9780446310789";
	
	public static void main(String[] args)
	{
		C3Client client = new C3Client();
		List<BookModel> books = client.getAll();
		
		for (BookModel book : books)
		{
			System.out.println(book.getAuthor());
		}
		
		BookModel model = client.getBook(FIELD, VALUE);
		BookView view = new BookView();
		BookController controller = new BookController(model, view);
		
		System.out.println(controller.getBookAuthor());
		System.out.println(controller.getBookName());
		
		controller.updateView();
		
		controller.setBookAuthor("The Author");
		controller.setBookName("My Book");
		controller.updateView();
		
		// starting cd model test
		
		CDModel cd = client.getCD("title", "cd_title1");
		System.out.println(cd.getArtist());
		System.out.println(cd.getTitle());
		System.out.println(cd.getInStock());
		
	}
}
