package com.c3mm.server.dba;

import java.net.*;
import java.io.*;

public class C3MultiServer
{
	private final static int PORT = 4000; 
	
	public static void main(String[] args) throws IOException
	{
		
		boolean listening = true;
		
		try (ServerSocket serverSocket = new ServerSocket(PORT))
		{
			System.out.println("Server Listening in port " + PORT);
			while (listening)
			{
				new C3ServerThread(serverSocket.accept()).start();
				System.out.println("New C3ThreadStated...");
			}
		}
		catch (IOException e)
		{
			System.err.println("Could not listen on port " + PORT);
			System.exit(-1);
		}
	}
}
