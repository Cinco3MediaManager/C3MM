package com.c3mm.client.view;

import java.util.HashMap;

public class View
{
	public void displayProperties(HashMap<String, String> props)
	{
		System.out.println("Model Properties:");
		for (HashMap.Entry<String, String> entry : props.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}
}
