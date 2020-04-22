package com.c3mm.client.controller;

import com.c3mm.client.model.CDModel;
//import com.c3mm.client.view.CDView;
import com.c3mm.client.view.View;

public class CDController
{
	private CDModel cd;
//	private CDView cdView;
	private View view;
	
//	public CDController(CDModel cd, CDView cdView)
//	{
//		this.cd = cd;
//		this.cdView = cdView;
//	}
	
	public CDController(CDModel cd, View view)
	{
		this.cd = cd;
		this.view = view;
	}
	
	public String getCDName()
	{
		return cd.getTitle();
	}
	
	public String getCDYear()
	{
		return cd.getYear();
	}
	
	public void updateView()
	{
		view.displayProperties(cd.getProperties());
	}
}
