package com.c3mm.client.model;
import java.io.*;
import java.net.*;

public class C3Client
{
	private BookModel book = null;
	private static String[] values = null;
	
	public static void runClient(String hostName, int port)
	{
		try (Socket socket = new Socket(hostName, port);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			String fromServer;
			String fromUser;
			
			while ((fromServer = in.readLine()) != null)
			{
				if (fromServer.equals("done."))
					break;

				System.out.println("Server: " + fromServer);
				setValues(fromServer.split(";"));
				
				fromUser = getQueryType();
				if (fromUser != null)
				{
					System.out.println("Client: " + fromUser);
					out.println(fromUser);
				}
			}
		}
		catch (UnknownHostException e)
		{
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		}
		catch (IOException e)
		{
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}

	private static String getQueryType()
	{
		return "book;1234567890";
	}

	public BookModel getBook()
	{
		return book;
	}

	public void setBook(BookModel book)
	{
		this.book = book;
	}

	public static String[] getValues()
	{
		return values;
	}

	public static void setValues(String[] values)
	{
		C3Client.values = values;
	}
}
