package com.c3mm.main;

import com.c3mm.client.model.Props.Table;
import java.util.HashMap;
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
	public static void main(String[] args)
	{
		C3Client client = new C3Client();
		View view = new View();
		BookModel book1 = new BookModel();
		
		System.out.println("------------------------------------------");
		System.out.println("Testing Insert");
		System.out.println("------------------------------------------");
		
		//Test setters
		book1.setTitle("MyBook1");
		book1.setAuthor("MyAuthor");
		book1.setInStock(5);
		book1.setPubDate("04-20-2020");
		book1.setIsbn("1234567899874");
		book1.setCountry("USA");
		book1.setType("print");
		book1.setLanguage("English");
		
		client.insert(book1.getProperties(), Table.BOOKS);
		
		view.displayProperties(book1.getProperties());
		
		
//		List<BookModel> books = client.getAllBooks();
//		for (BookModel book : books)
//		{
//			System.out.println(book.getAuthor());
//		}
//		
//		BookModel book = client.getBook("book_id", "1");
//		client.insert(book.getProperties(), "books");
//		BookController controller = new BookController(model, view);
//		
//		System.out.println(controller.getBookAuthor());
//		System.out.println(controller.getBookName());
//		
//		controller.updateView();
//		controller.setBookAuthor("The Author");
//		controller.setBookName("My Book");
//		controller.updateView();
		
		// starting cd model test		
//		CDModel cd = client.getCD("cd_id", "1");
//		client.insert(cd.getProperties(), "cds");
//		CDController cdController = new CDController(cd, view);
//		
//		System.out.println(cdController.getCDName());
//		System.out.println(cdController.getCDYear());
//		
//		cdController.updateView();
//		
//		List<CDModel> cds = client.getAllCDs();
////		
//		for (CDModel c : cds)
//		{
//			System.out.println(c.getArtist());
//		}
//		if (cd != null)
//			view.displayProperties(cd.getProperties());
//		
//		if (client.updateCD("in_stock", "1", "1"))
//		{
//			System.out.println("Success");
//		}
//		
//		cd = client.getCD("cd_id", "1");
//		view.displayProperties(cd.getProperties());
//		
//		client.insert(new BookModel());
//		cdController.updateView();
//		
//		cdController = new CDController(cd, view);
//		
//		System.out.println(cdController.getCDName());
//		System.out.println(cdController.getCDYear());
//		
//		cdController.updateView();
//		
//		// starting movie model test		
//		MovieModel movie = client.getMovie("title", "movie1");
//		client.insert(movie.getProperties(), "movies");
//		MovieController movControl = new MovieController(movie, view);
//		
//		System.out.println(cdController.getCDName());
//		System.out.println(cdController.getCDYear());
//		
//		movControl.updateView();
//		
//		for (MovieModel m: client.getAllMovies())
//		{
//			System.out.println(m.getDirector());
//		}
	}
}
