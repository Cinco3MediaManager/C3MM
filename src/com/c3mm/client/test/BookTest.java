package com.c3mm.client.test;

import java.util.HashMap;

import com.c3mm.client.model.BookModel;

public class BookTest
{
	public static void runBookTest()
	{
		//Test no arg Constructor
		System.out.println("------------------------------------------");
		System.out.println("STARTING BOOK TEST...");
		System.out.println("------------------------------------------");

		BookModel book1 = new BookModel();
		
		//Test getters
		System.out.println("Testing No-arg constructor:");
		System.out.println("Values should be empty or default.");
		System.out.println("------------------------------------------");
		HashMap<String, String> props1 = book1.getProperties();
		for (HashMap.Entry<String, String> entry : props1.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		//Test setters
		book1.setRecId(1); //Just for testing, field is unique in DB it won't let you update it
		book1.setTitle("MyBook1");
		book1.setAuthor("MyAuthor");
		book1.setInStock(5);
		book1.setPubDate("04-20-2020");
		book1.setIsbn("0101010101");
		book1.setCountry("USA");
		book1.setType("print");
		book1.setLanguage("english");
		
		//display values
		System.out.println("------------------------------------------");
		System.out.println("After setting the properties:\nValues should be populated.");
		System.out.println("------------------------------------------");
		
		props1 = book1.getProperties();
		for (HashMap.Entry<String, String> entry : props1.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		//TODO do we need the 3rd contructor???
		
		// Test second contructor
		BookModel book2 = new BookModel(1, "mybook2", "MyAuthor2", 5, "01-01-1999", "9879879874", "usa", "stream", "english");
		
		// display values
		System.out.println("------------------------------------------");
		System.out.println("Second Constructor:");
		System.out.println("Model has all properties from contructor.");
		System.out.println("------------------------------------------");
		HashMap<String, String> props2 = book2.getProperties();
		for (HashMap.Entry<String, String> entry : props2.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		// Test setters
		System.out.println("------------------------------------------");
		System.out.println("After invoking the setters to change values:");
		System.out.println("------------------------------------------");

		book2.setTitle("MyBook2");
		book2.setAuthor("MyAuthor2");
		book2.setInStock(5);
		book2.setPubDate("04-20-2020");
		book2.setIsbn("999888777555");
		book2.setCountry("USA");
		book2.setType("print");
		book2.setLanguage("english");
		
		//Display new values
		props2 = book2.getProperties();
		for (HashMap.Entry<String, String> entry : props2.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
	}

}
