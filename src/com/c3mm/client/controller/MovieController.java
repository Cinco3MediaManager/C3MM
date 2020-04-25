package com.c3mm.client.controller;

import com.c3mm.client.model.MovieModel;
import com.c3mm.client.view.View;

public class MovieController
{
	private MovieModel movie;
	private View view;
	
	public MovieController(MovieModel movie, View view)
	{
		this.movie = movie;
		this.view = view;
	}
	
	public String getMovieName()
	{
		return movie.getTitle();
	}
	
	public String getMovieYear()
	{
		return movie.getYear();
	}
	
	public void updateView()
	{
		view.displayProperties(movie.getProperties());
	}
}
