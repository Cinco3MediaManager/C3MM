package com.c3mm.server.dba;

import java.util.Vector;

public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_SENT = 2;
	
	private static final String BOOKS = "books";
	private static final String DONE = "done.";
	private static final String CONNECTING = "Connecting to server...";
	
	private int state = WAITING; // we always start waiting
	
	private Vector<String> results = new Vector<String>();
	
	public String processInput(String theInputs)
	{
		String theOutput = "";
		String[] args = null;
		String table = "";
		String param = "";
		
		if (theInputs != null) 
		{
			 args = theInputs.split(";");
			 table = args[0];
			 param = args[1];
		}
		
		if (state == WAITING)
		{
			theOutput = CONNECTING;
			state = TRY_QUERY;
		}
		else if (state == TRY_QUERY)
		{
			switch (table) {
			case BOOKS:
				if (param.equalsIgnoreCase("all"))
				{
					results = new C3DBA().getBooks();
					theOutput = "multiple";
				}
				else
				{
					C3DBA bookquery = new C3DBA();
					bookquery.getBook(table, param);
					results = bookquery.getRows();
					theOutput = "single";
				}
				break;
			}
			
			state = QUERY_SENT;
		}
		else
		{
			theOutput = DONE;
			state = WAITING;
		}
		return theOutput;
	}

	public Vector<String> getResults() {
		return results;
	}

	public void setResults(Vector<String> results) {
		this.results = results;
	}

}
