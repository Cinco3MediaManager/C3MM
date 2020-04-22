package com.c3mm.server.dba;

import java.net.*;
import java.io.*;

public class C3ServerThread extends Thread
{
	private Socket socket = null;
	private final static String DONE = "done.";
	private static final String NOT_FOUND = "no results found";
	// private final static String SINGLE = "single";
	private final static String FOUND = "found";
	
	public C3ServerThread(Socket socket)
	{
		super("C3ServerThread");
		this.socket = socket;
	}
	
	@Override
	public void run()
	{
		try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			String inputLine, outputLine;
			DBAProtocol dbap = new DBAProtocol(); // start the communication protocol
			outputLine = dbap.processInput(null); // get the first server response
			out.println(outputLine); // send it to the client
			
			while ((inputLine = in.readLine()) != null) // read from the client
			{
				outputLine = dbap.processInput(inputLine);
				
				if (outputLine.equals(DONE)) // if server response is done quit loop close connection
					break;
				
				if (outputLine.equals(NOT_FOUND))
					break;
				
				if (outputLine.equals(FOUND))
				{
					for (String s : dbap.getResults())
					{
						out.println(s);
					}
					out.println(DONE);
				}
				
				out.println(outputLine); // send the response to the client
			}
			
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
