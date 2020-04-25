package com.c3mm.client.test;

import java.util.HashMap;

import com.c3mm.client.model.MovieModel;

public class MovieTest
{
	public static void runMovieTest()
	{
		//Test no arg Constructor
		System.out.println("------------------------------------------");
		System.out.println("STARTING MOVIE TEST...");
		System.out.println("------------------------------------------");
		MovieModel movie1 = new MovieModel();
		
		//Test getters
		System.out.println("Testing No-arg constructor:");
		System.out.println("Values should be empty or default.");
		System.out.println("------------------------------------------");
		HashMap<String, String> props1 = movie1.getProperties();
		for (HashMap.Entry<String, String> entry : props1.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		//Test setters
		movie1.setRecId(1); //Just for testing, field is unique in DB it won't let you update it
		movie1.setInStock(5);
		movie1.setTitle("MyMovie1");
		movie1.setCountry("USA");
		movie1.setType("dvd");
		movie1.setLanguage("english");
		movie1.setDirector("TheDirector1");
		movie1.setYear("1999");
		
		//display values
		System.out.println("------------------------------------------");
		System.out.println("After setting the properties:\nValues should be populated.");
		System.out.println("------------------------------------------");
		
		props1 = movie1.getProperties();
		for (HashMap.Entry<String, String> entry : props1.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		//TODO do we need the 3rd contructor???
		
		// Test second contructor
		MovieModel movie2 = new MovieModel(1, 5, "mymovie2", "usa", "stream", "english", "MyDirector2", "1999");
		
		// display values
		System.out.println("------------------------------------------");
		System.out.println("Second Constructor:");
		System.out.println("Model has all properties from contructor.");
		System.out.println("------------------------------------------");
		HashMap<String, String> props2 = movie2.getProperties();
		for (HashMap.Entry<String, String> entry : props2.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		// Test setters
		System.out.println("------------------------------------------");
		System.out.println("After invoking the setters to change values:");
		System.out.println("------------------------------------------");

		movie2.setInStock(5);
		movie2.setTitle("MyMovieTitle2");
		movie2.setCountry("USA");
		movie2.setType("Tape");
		movie2.setLanguage("english");
		movie2.setDirector("MyMovieDirector2");
		movie2.setYear("2010");
		
		//Display new values
		props2 = movie2.getProperties();
		for (HashMap.Entry<String, String> entry : props2.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
	}

}
