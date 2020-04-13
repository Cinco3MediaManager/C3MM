package com.c3mm.server.dba;
public class DBAProtocol
{
	private static final int WAITING = 0;
	private static final int TRY_QUERY = 1;
	private static final int QUERY_SENT = 2;
	// private static final int SENTCLUE = 2;
	// private static final int ANOTHER = 3;
	
	// private static final int NUMJOKES = 5;
	
	private int state = WAITING;
	// private int currentJoke = 0;
	
	// private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who"
	// };
	// private String[] answers = { "Turnip the heat, it's cold in here!", "I didn't
	// know you could yodel!", "Bless you!",
	// "Is there an owl in here?", "Is there an echo in here?" };
	
	public String processInput(String theInput)
	{
		String theOutput = "";
		String[] args = null;
		if (theInput != null) {
			 args= theInput.split(";");
		}
		
		if (state == WAITING)
		{
			theOutput = "Connecting to server..";
			state = TRY_QUERY;
		}
		else if (state == TRY_QUERY)
		{
			if (args[0].equalsIgnoreCase("book"))
				theOutput = C3DBA.getBook(args[1]);
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
