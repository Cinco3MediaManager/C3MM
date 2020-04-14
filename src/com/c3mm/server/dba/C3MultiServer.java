package com.c3mm.server.dba;

import java.net.*;
import java.io.*;

public class C3MultiServer
{
	public static void main(String[] args) throws IOException
	{
		if (args.length != 1)
		{
			System.err.println("Usage: java C3MultiServer <port number>");
			System.exit(1);
		}
		
		int portNumber = Integer.parseInt(args[0]);
		boolean listening = true;
		
		try (ServerSocket serverSocket = new ServerSocket(portNumber))
		{
			System.out.println("Server Listening in port " + portNumber);
			while (listening)
			{
				new C3ServerThread(serverSocket.accept()).start();
				System.out.println("New C3ThreadStated...");
			}
		}
		catch (IOException e)
		{
			System.err.println("Could not listen on port " + portNumber);
			System.exit(-1);
		}
	}
}
