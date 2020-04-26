package com.c3mm.client.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.model.C3Client;
import com.c3mm.client.model.CDModel;
import com.c3mm.client.model.MovieModel;
import com.c3mm.client.model.Props.Table;
import com.c3mm.client.view.View;
/**
 * This class tests all the methods in the C3Client.<br>
 * Remember before running this class, the server has to be started.
 * To run the server go to server.dba package and run the C3Multiserver class.
 * <br>
 * Additionally, this tests are dependent on database constraints.
 * Check the server output for SQLite errors if the tests don't work.
 * <br>
 * Generally, the get methods will work as long as you pass existing records.
 * The inserts and updates are usually the main source of failures.
 * The reason is that the program is trying to insert or update a record
 * in a way that violates the database constraints. 
 *
 * @author power-serge
 */
public class ClientTest
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		boolean append = true;
		boolean autoFlush = true;
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy@HH.mm.ss");
		String log = formatter.format(new Date()) + ".txt";
		PrintStream out = new PrintStream(new FileOutputStream(log, append), autoFlush);
		System.setOut(out);
		System.setErr(out);
		
		// TEST WILL FAIL UNLESS SERVER IS RUNNING!!!
		System.out.println("STARTING CLIENT TEST..." + log);
		System.out.println("BEWARE: TEST WILL FAIL UNLESS SERVER IS RUNNING!!!");
		
		//Create the client
		C3Client client = new C3Client();
		View view = new View(); // use view to display information/also works to test the view :)
		
		//Test getBook
		System.out.println("------------------------------------------");
		System.out.println("Testing getBook:");
		System.out.println("------------------------------------------");
		BookModel book = client.getBook("book_id", "5"); //get book by id
		view.displayProperties(book.getProperties());
		
		//Test getAllBooks
		System.out.println("------------------------------------------");
		System.out.println("Testing getAllBooks:");
		System.out.println("------------------------------------------");
		for (BookModel b : client.getAllBooks())
		{
			view.displayProperties(b.getProperties());
		}
		
		//Test insert with book (the right way)
		System.out.println("------------------------------------------");
		System.out.println("Testing Insert (Book)");
		System.out.println("------------------------------------------");
		
		BookModel book1 = new BookModel();
		book1.setTitle("MyBook6");
		book1.setAuthor("MyAuthor6");
		book1.setInStock(5);
		book1.setPubDate("04-20-2020");
		book1.setIsbn("0000111122223");
		book1.setCountry("USA");
		book1.setType("print");
		book1.setLanguage("English");
		
		client.insert(book1.getProperties(), Table.BOOKS); // insert into the db
		book1 = client.getBook("isbn", book1.getIsbn()); // retrieve from the db
		if (book1 != null)
			view.displayProperties(book1.getProperties());
		else
			System.out.println("Book could not be retrieved");
		
		//Test updateBook
		System.out.println("------------------------------------------");
		System.out.println("Testing updateBook");
		System.out.println("------------------------------------------");
		client.updateBook("title", "MyTitleTest6", String.valueOf(book1.getRecId() )); // update the db
		book1 = client.getBook("title", "MyTitleTest6"); // update the model with the new values
		if (book1 != null)
			view.displayProperties(book1.getProperties());
		else
			System.out.println("Book could not be retrieved");
		
		//Test getCD
		System.out.println("------------------------------------------");
		System.out.println("Testing getCD");
		System.out.println("------------------------------------------");
		CDModel cd = client.getCD("cd_id", "1");//getCD by id
		view.displayProperties(cd.getProperties());
		
		//Test getAllCDs
		System.out.println("------------------------------------------");
		System.out.println("Testing getAllCDs");
		System.out.println("------------------------------------------");
		for (CDModel c : client.getAllCDs())
		{
			view.displayProperties(c.getProperties());
		}
		
		//Test insert cd
		System.out.println("------------------------------------------");
		System.out.println("Testing Insert (CD)");
		System.out.println("------------------------------------------");
		
		CDModel cd1 = new CDModel();
		cd1.setInStock(5);
		cd1.setTitle("MyNewCD9");
		cd1.setCountry("USA");
		cd1.setType("collection");
		cd1.setLanguage("English");
		cd1.setArtist("MyNewArtist9");
		cd1.setYear("04-20-2010");
		
		client.insert(cd1.getProperties(), Table.CDS); // insert into the db
		cd1 = client.getCD("title", cd1.getTitle()); // retrieve from the db
		if (cd1 != null)
			view.displayProperties(cd1.getProperties());
		else
			System.out.println("Could not retrieve CD");
		
		//Test updateCD
		System.out.println("------------------------------------------");
		System.out.println("Testing updateCD");
		System.out.println("------------------------------------------");
		client.updateCD("in_stock", "8", String.valueOf( cd1.getRecId() ));//update cds set in_stock = '0' where cd_id = ?
		cd1 = client.getCD("cd_id", String.valueOf( cd1.getRecId() )); // retrieve the updated values into the model
		if (cd1 != null)
			view.displayProperties(cd1.getProperties()); //stock should be 8
		else
			System.out.println("Could not retrieve CD");
		
		// Test getMovie
		System.out.println("------------------------------------------");
		System.out.println("Testing getMovie:");
		System.out.println("------------------------------------------");
		MovieModel movie = client.getMovie("movie_id", "1"); // you get the idea
		view.displayProperties(movie.getProperties());
		
		// Test getAllMovies
		System.out.println("------------------------------------------");
		System.out.println("Testing getAllMovies");
		System.out.println("------------------------------------------");
		for (MovieModel m: client.getAllMovies())
		{
			view.displayProperties(m.getProperties());
		}
		
		// Test Insert Movie
		System.out.println("------------------------------------------");
		System.out.println("Testing Insert (movie)");
		System.out.println("------------------------------------------");
		MovieModel movie1 = new MovieModel();
		movie1.setInStock(5);
		movie1.setTitle("MyNewmovie");
		movie1.setCountry("USA");
		movie1.setType("dvd");
		movie1.setLanguage("English");
		movie1.setDirector("MyDirector");
		movie1.setYear("04-20-2010");
		
		client.insert(movie1.getProperties(), Table.MOVIES); // insert into the db
		movie1 = client.getMovie("title", movie1.getTitle()); // update the model with values from the db
		if(movie1 != null)
			view.displayProperties(movie1.getProperties());
		else
			System.out.println("Could not retrieve Movie");
		
		//Test updateMovie
		System.out.println("------------------------------------------");
		System.out.println("Testing updateMovie");
		System.out.println("------------------------------------------");
		client.updateMovie("in_stock", "4", String.valueOf( movie1.getRecId() ));//update movies set in_stock = '2' where movie_id = '1'
		movie1 = client.getMovie("movie_id", String.valueOf( movie1.getRecId() )); // retrieve the updated values into the model
		
		if (movie1 != null)
		{
			view.displayProperties(movie1.getProperties());
		}
		else
		{
			System.out.println("Could not retrieve Movie");
		}
	}
}



























