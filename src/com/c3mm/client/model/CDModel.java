package com.c3mm.client.model;

import java.util.HashMap;

/**
 * CD Entity Definition in DB
 *  cd_id    INTEGER PRIMARY KEY AUTOINCREMENT,
 *  in_stock INTEGER NOT NULL,
 *  title    TEXT    NOT NULL,
 *  country  TEXT,
 *  type     TEXT    NOT NULL
 *                   CONSTRAINT chk_type CHECK (type IN ('single', 'collection', 'course') ),
 *  language TEXT,
 *  artist   TEXT    NOT NULL,
 *  year     TEXT    NOT NULL
 *  
 * @author S3ry0u5
 */
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
		props.put(Props.ID, String.valueOf(this.getRecId()));
		props.put(Props.STOCK, String.valueOf(this.getInStock()));
		props.put(Props.TITLE, this.getTitle());
		props.put(Props.COUNTRY, this.getCountry());
		props.put(Props.TYPE, this.getType());
		props.put(Props.LANG, this.getLanguage());
		props.put(Props.ARTIST, this.getArtist());
		props.put(Props.YEAR, this.getYear());
		
		return props;
	}
	
	
}
