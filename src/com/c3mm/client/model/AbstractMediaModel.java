package com.c3mm.client.model;

public abstract class AbstractMediaModel
{
	private int rec_id;
	private int inStock;
	private String title;
	private String country;
	private String type;
	private String language;
	
	/**
	 * Default No arg constructor Initializes all the instance variables to default
	 * values
	 */
	public AbstractMediaModel()
	{
		rec_id = 0;
		inStock = 0;
		title = "";
		setCountry("");
		type = "";
		language = "";
	}
	
	/**
	 * Create media object with all needed params
	 * @param rec_id
	 * @param inStock
	 * @param title
	 * @param country
	 * @param type
	 * @param language
	 */
	public AbstractMediaModel(int rec_id, int inStock, String title, String country, String type, String language)
	{
		super();
		this.rec_id = rec_id;
		this.inStock = inStock;
		this.title = title;
		this.setCountry(country);
		this.type = type;
		this.language = language;
	}
	
	public int getRecId()
	{
		return rec_id;
	}

	public void setRecId(int rec_id)
	{
		this.rec_id = rec_id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public int getInStock()
	{
		return inStock;
	}

	public void setInStock(int inStock)
	{
		this.inStock = inStock;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}
}
