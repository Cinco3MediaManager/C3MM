package com.c3mm.client.test;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.model.Props.Table;
import com.c3mm.client.view.View;

public class ClientTest
{
	public static void main(String[] args)
	{
		// TEST WILL FAIL UNLESS SERVER IS RUNNING!!!
		System.out.println("STARTING CLIENT TEST...");
		
		//Create the client
		C3Client client = new C3Client();
		View view = new View(); // use view to display information/also works to test the view :)
//		
//		//Test getBook
//		System.out.println("------------------------------------------");
//		System.out.println("Testing getBook:");
//		System.out.println("------------------------------------------");
//		BookModel book = client.getBook("book_id", "5"); //get book by id
//		view.displayProperties(book.getProperties());
//		
//		//Test getAllBooks
//		System.out.println("------------------------------------------");
//		System.out.println("Testing getAllBooks:");
//		System.out.println("------------------------------------------");
//		for (BookModel b : client.getAllBooks())
//		{
//			view.displayProperties(b.getProperties());
//		}
//		
//		//Test insert with book (the right way)
//		System.out.println("------------------------------------------");
//		System.out.println("Testing Insert");
//		System.out.println("------------------------------------------");
//		
//		BookModel book1 = new BookModel();
//		book1.setTitle("MyBook2");
//		book1.setAuthor("MyAuthor");
//		book1.setInStock(5);
//		book1.setPubDate("04-20-2020");
//		book1.setIsbn("0001112223334");
//		book1.setCountry("USA");
//		book1.setType("print");
//		book1.setLanguage("English");
//		
//		client.insert(book1.getProperties(), Table.BOOKS); // insert into the db
//		book1 = client.getBook("isbn", "0001112223334"); // retrieve from the db
//		view.displayProperties(book1.getProperties());
		
		//Test updateBook
		System.out.println("------------------------------------------");
		System.out.println("Testing updateBook");
		System.out.println("------------------------------------------");
		client.updateBook("isbn", "9780307474278", "6"); // update the db
		BookModel book = client.getBook("book_id", "90"); // update the model
		view.displayProperties(book.getProperties());
		
//		//Test getCD
//		CDModel cd = client.getCD("cd_id", "1");//getCD by id
//		view.displayProperties(cd.getProperties());
//		
//		//Test getAllCDs
//		for (CDModel c : client.getAllCDs())
//		{
//			view.displayProperties(c.getProperties());
//		}
//		
//		//Test updateCD
//		client.updateCD("in_stock", "0", "1");//update cds set in_stock = '0' where cd_id = '1'
//		cd = client.getCD("cd_id", "1"); // retrieve the updated values into the model
//		view.displayProperties(cd.getProperties()); //stock should be zero
//		
//		// Test getMovie
//		MovieModel movie = client.getMovie("movie_id", "1"); // you get the idea
//		view.displayProperties(movie.getProperties());
//		
//		// Test getAllMovies
//		for (MovieModel m: client.getAllMovies())
//		{
//			view.displayProperties(m.getProperties());
//		}
		
		//TODO Test updateMovie
	}
}
