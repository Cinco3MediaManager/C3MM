package com.c3mm.main;

import java.util.List;

import com.c3mm.client.controller.BookController;
import com.c3mm.client.controller.CDController;
import com.c3mm.client.controller.MovieController;
import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.view.View;

public class ModelTest
{
	/* Constants for testing for now */
	private final static String FIELD = "isbn";
	private final static String VALUE = "9780446310789";
	
	public static void main(String[] args)
	{
		C3Client client = new C3Client();
		List<BookModel> books = client.getAllBooks();
		View view = new View();
		
		for (BookModel book : books)
		{
			System.out.println(book.getAuthor());
		}
		
		BookModel model = client.getBook(FIELD, VALUE);
		BookController controller = new BookController(model, view);
		
		System.out.println(controller.getBookAuthor());
		System.out.println(controller.getBookName());
		
		controller.updateView();
		controller.setBookAuthor("The Author");
		controller.setBookName("My Book");
		controller.updateView();
		
		// starting cd model test		
		CDModel cd = client.getCD("title", "cd_title2");
		CDController cdController = new CDController(cd, view);
		
		System.out.println(cdController.getCDName());
		System.out.println(cdController.getCDYear());
		
		cdController.updateView();
		
		List<CDModel> cds = client.getAllCDs();
		
		for (CDModel c : cds)
		{
			System.out.println(c.getArtist());
		}
		
		client.updateCD("title", "The New CD Title", "1");
		cd = client.getCD("cd_id", "1");
		cdController.updateView();
		
		cdController = new CDController(cd, view);
		
		System.out.println(cdController.getCDName());
		System.out.println(cdController.getCDYear());
		
		cdController.updateView();
		
		// starting movie model test		
		MovieModel movie = client.getMovie("title", "movie1");
		MovieController movControl = new MovieController(movie, view);
		
		System.out.println(cdController.getCDName());
		System.out.println(cdController.getCDYear());
		
		movControl.updateView();
		
		for (MovieModel m: client.getAllMovies())
		{
			System.out.println(m.getDirector());
		}
	}
}
