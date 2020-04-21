package com.c3mm.server.dba;

import java.util.Vector;

public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_DONE = 2;
	
	private static final String DONE = "done.";
	private static final String CONNECTING = "Connecting to server...";
//	private static final String EMPTY = "";
	private final static String FOUND = "found";
	private static final String NOT_FOUND = "no results found";
	
	private int state = WAITING; // we always start waiting
	
	private Vector<String> results = new Vector<String>();
	
	public String processInput(String theInputs)
	{
		String theOutput = "";
		String[] args = null;
		
		// values needed for query
		String table = "";
		String param = ""; 
		String lookUpVal = "";
		
		if (state == WAITING)
		{
			theOutput = CONNECTING;
			state = TRY_QUERY;
		}
		else if (state == TRY_QUERY)
		{
			C3DBA query = new C3DBA();
			if (theInputs != null)
			{
				args = theInputs.split(";");
				table = args[0]; //should always send at least the table
				
				if (args.length == 3)
				{
					param = args[1];
					lookUpVal = args[2];
					query.selectAll(table, param, lookUpVal);
				}
				else 
				{
					query.selectAll(table, param, lookUpVal); // here only table would have a value, this would return all rows
				}
			}
			
			results = query.getRows();
			
//			switch (table) {
//			case BOOKS:
//				if (param.equalsIgnoreCase("all"))
//				{
//					results = new C3DBA().getBooks();
//					theOutput = "multiple";
//				}
//				else
//				{
//					C3DBA bookquery = new C3DBA();
//					bookquery.selectAll(table, param, lookUpVal);
//					results = bookquery.getRows();
//					theOutput = "single";
//				}
//				break;
//			}
			if (!results.isEmpty())
			{
				theOutput = FOUND;
			}
			else
			{
				theOutput = NOT_FOUND;
			}
			
			state = QUERY_DONE;
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
}
