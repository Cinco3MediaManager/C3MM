package com.c3mm.client.model;

public abstract class AbstractMediaModel
{
	private int rec_id = 0;
	private String status;
	private String title;
	private String location;
	private String pubDate; // publication date
	
	/**
	 * Default No arg constructor Initializes all the instance variables to default
	 * values
	 */
	public AbstractMediaModel()
	{
		this.setRecId(0);
		this.status = "";
		this.title = "";
		this.location = "";
		this.pubDate = "";
	}
	
	/**
	 * Convenience method to create a Model object with all parameters given
	 * @param record_id
	 * @param status
	 * @param author
	 * @param title
	 * @param location
	 * @param pubDate
	 */
	public AbstractMediaModel(int rec_id, String status, String title, String location,
			String pubDate)
	{
		this.rec_id = rec_id;
		this.status = status;
		this.title = title;
		this.location = location;
		this.pubDate = pubDate;
	}
	
	public int getRecId()
	{
		return rec_id;
	}
	
	public void setRecId(int rec_id)
	{
		this.rec_id = rec_id;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String getPubDate()
	{
		return pubDate;
	}
	
	public void setPubDate(String pubDate)
	{
		this.pubDate = pubDate;
	}
}
