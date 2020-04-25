package com.c3mm.client.test;

import java.util.HashMap;

import com.c3mm.client.model.CDModel;

public class CDTest
{
	public static void runCDTest()
	{
		//Test no arg Constructor
		System.out.println("------------------------------------------");
		System.out.println("STARTING CD TEST...");
		System.out.println("------------------------------------------");

		CDModel cd1 = new CDModel();
		
		//Test getters
		System.out.println("Testing No-arg constructor:");
		System.out.println("Values should be empty or default.");
		System.out.println("------------------------------------------");
		HashMap<String, String> props1 = cd1.getProperties();
		for (HashMap.Entry<String, String> entry : props1.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		//Test setters
		cd1.setRecId(1); //Just for testing, field is unique in DB it won't let you update it
		cd1.setInStock(5);
		cd1.setTitle("MyAlbum1");
		cd1.setCountry("USA");
		cd1.setType("single");
		cd1.setLanguage("english");
		cd1.setArtist("TheArtist1");
		cd1.setYear("1999");
		
		//display values
		System.out.println("------------------------------------------");
		System.out.println("After setting the properties:\nValues should be populated.");
		System.out.println("------------------------------------------");
		
		props1 = cd1.getProperties();
		for (HashMap.Entry<String, String> entry : props1.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		//TODO do we need the 3rd contructor???
		
		// Test second contructor
		CDModel cd2 = new CDModel(1, 5, "mycd2", "usa", "collection", "english", "MyArtist2", "1999");
		
		// display values
		System.out.println("------------------------------------------");
		System.out.println("Second Constructor:");
		System.out.println("Model has all properties from contructor.");
		System.out.println("------------------------------------------");
		HashMap<String, String> props2 = cd2.getProperties();
		for (HashMap.Entry<String, String> entry : props2.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
		
		// Test setters
		System.out.println("------------------------------------------");
		System.out.println("After invoking the setters to change values:");
		System.out.println("------------------------------------------");

		cd2.setInStock(5);
		cd2.setTitle("MyAlbumTitle2");
		cd2.setCountry("USA");
		cd2.setType("Collection");
		cd2.setLanguage("english");
		cd2.setArtist("MyAlbumArtist2");
		cd2.setYear("2010");
		
		//Display new values
		props2 = cd2.getProperties();
		for (HashMap.Entry<String, String> entry : props2.entrySet())
			System.out.println(entry.getKey().toUpperCase() + ": " + entry.getValue());
	}

}
