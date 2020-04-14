package com.c3mm.server.dba;
public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_SENT = 2;
	
	private static final String BOOKS = "books";
	
	private int state = WAITING; // we always start waiting
	
	public String processInput(String theInput)
	{
		String theOutput = "";
		String[] args = null;
		
		if (theInput != null) 
		{
			 args = theInput.split(";");
		}
		
		if (state == WAITING)
		{
			theOutput = "Connecting to server..";
			state = TRY_QUERY;
		}
		else if (state == TRY_QUERY)
		{
			if (args[0].equalsIgnoreCase(BOOKS))
			{
				theOutput = new C3DBA().getBook(BOOKS, args[1]);
			}

			state = QUERY_SENT;
		}
		else
		{
			theOutput = "done.";
			state = WAITING;
		}
		return theOutput;
	}
}
