package com.c3mm.server.dba;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class C3MultiServer
{
	private final static int PORT = 4000; 
	private final static String START_MSG = "New C3Thread Started at...";
	private final static String LISTENING = "Server Listening in port " + PORT;
	private final static String IO_ERROR = "Could not listen on port " + PORT;
	
	public static void main(String[] args) throws IOException
	{
		
		boolean listening = true;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String dateTime = null;
		
		try (ServerSocket serverSocket = new ServerSocket(PORT))
		{
			System.out.println(LISTENING);
			while (listening)
			{
				dateTime = formatter.format(new Date());
				new C3ServerThread(serverSocket.accept()).start();
				System.out.println(START_MSG + dateTime);
			}
		}
		catch (IOException e)
		{
			System.err.println(IO_ERROR);
			System.exit(-1);
		}
	}
}
