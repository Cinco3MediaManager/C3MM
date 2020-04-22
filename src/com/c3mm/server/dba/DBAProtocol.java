package com.c3mm.server.dba;

import java.util.Vector;

public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_DONE = 2;
	
	private static final String DONE = "done.";
	private static final String CONNECTING = "Connecting to server...";
	private final static String FOUND = "found";
	private static final String NOT_FOUND = "no results found";
	
	private static final String SELECT = "s";
	private static final String UPDATE = "u";
	private static final String INSERT = "i";
	
	
	private int state = WAITING; // we always start waiting
	
	private Vector<String> results = new Vector<String>();
	
	public String processInput(String theInputs)
	{
		String theOutput = "";
		String[] args = null;
		
		String queryType = "";
		String table = "";;
		String field = "";; 
		String value = "";;
		
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
				queryType = args[0];
				table = args[1];

				if (args.length == 4)
				{
					field = args[2];
					value = args[3];
				}
				
				switch (queryType)
				{
					case SELECT:
						query.select(table, field, value);
						break;
					case UPDATE:
						query.update(table, field, value);
						break;
					case INSERT:
						query.insert(table, field, value);
						break;
				}
			}
			
			results = query.getRows();
			
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
