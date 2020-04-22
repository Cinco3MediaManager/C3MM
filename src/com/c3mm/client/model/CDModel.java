package com.c3mm.client.model;

import java.util.HashMap;

public class CDModel extends AbstractMediaModel
{
	private String artist;
	private String year; // released year
	
	/**
	 * Initialize the model variables
	 */
	public CDModel()
	{
		super();
		this.artist = "";
		this.year = "";
	}
	
	public CDModel(int rec_id, int inStock, String title, String country, String type, String language, String artist,
			String year)
	{
		super(rec_id, inStock, title, country, type, language);
		this.artist = artist;
		this.year = year;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}
	
	public HashMap<String, String> getProperties()
	{
		HashMap<String, String>	props = new HashMap<String, String>();
		props.put("id", String.valueOf(this.getRecId()));
		props.put("stock", String.valueOf(this.getInStock()));
		props.put("title", this.getTitle());
		props.put("country", this.getCountry());
		props.put("type", this.getType());
		props.put("lang", this.getLanguage());
		props.put("artist", this.getArtist());
		props.put("year", this.getYear());
		
		return props;
	}
	
	
}
