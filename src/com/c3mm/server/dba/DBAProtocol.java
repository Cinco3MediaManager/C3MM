package com.c3mm.server.dba;

import java.util.Vector;
import com.c3mm.client.model.Props.Comms;

public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_DONE = 2;
	
	private static final String CONNECTING = "Connecting to server...";
	
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
					case Comms.SEL:
						query.select(table, field, value);
						break;
					case Comms.UPD:
						query.update(table, field, value);
						break;
					case Comms.INS:
						query.insert(table, field, value);
						break;
				}
			}
			
			results = query.getRows();
			
			if (!results.isEmpty())
			{
				theOutput = Comms.FOUND;
			}
			else
			{
				theOutput = Comms.NOT_FOUND;
			}
			
			state = QUERY_DONE;
		}
		else
		{
			theOutput = Comms.DONE;
			state = WAITING;
		}
		return theOutput;
	}
	
	public Vector<String> getResults()
	{
		return results;
	}
}
