package com.c3mm.client.model;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.c3mm.client.model.Props.Comms;

public class C3Client
{
	/* Constants for program configuration */
	private static final String SERVER = "Server-> ";
	private static final String CLIENT = "Client-> ";
	private static final String UNKNOWN_HOST = "The specified host could not be found: ";
	private static final String IO_HOST = "Couldn't get I/O for the connection to ";
	private static final String HOST = "localhost"; //change to connect across computers
	private static final int PORT = 4000; //change to connect across computers
	
	Vector<String> results = null;
	
	private void sendRequest(String message)
	{
		try (Socket socket = new Socket(HOST, PORT); // connect to the server socket. 
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // use this to send requests to server
				BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()) ); ) // use this to read response from server 
		{
			results = new Vector<String>();
			String fromServer;
			String fromClient;
			
			// This loop executes every time the server sends a response
			while ((fromServer = in.readLine()) != null) // read from the server
			{
				System.out.println(SERVER + fromServer); // tell me what the server said
				
				if ( fromServer.equals(Comms.DONE) ) // if the server sends "done.", exit the loop and close connection
					break;
				
				if( fromServer.contains(Comms.NOT_FOUND) ) // if the query returns no results exit the loop
					break;
				
				if( fromServer.contains(Comms.DELIM) ) // the delimiter indicates we received something back
				{
					results.add(fromServer);
					continue; // skip to read the next server response
				}
				
				fromClient = message;
				
				if (fromClient != null)
				{
					System.out.println(CLIENT + fromClient); // show me what I am sending to the server
					out.println(fromClient); // send it to the server
				}
			}
		}
		catch (UnknownHostException e)
		{
			System.err.println(UNKNOWN_HOST + HOST);
			System.exit(1);
		}
		catch (IOException e)
		{
			System.err.println(IO_HOST + HOST);
			System.exit(1);
		}
	}
	
	public BookModel getBook(String field, String param)
	{
		String message = Comms.BOOKS_MSG + field + Comms.DELIM + param;
		sendRequest(message);
		String[] values = results.get(0).split(Comms.DELIM);
		
		return new BookModel(Integer.parseInt(values[0]), // id
				values[1], // title
				values[2], // author
				Integer.parseInt(values[3]), // in-stock
				values[4], // publication date
				values[5], // ISBN
				values[6], // country
				values[7], // type
				values[8]  // language
		);
	}
	
	public List<BookModel> getAllBooks()
	{
		sendRequest(Comms.BOOKS_ALL);
		List<BookModel> books = new LinkedList<>();
		
		for (String row : results)
		{
			String[] values = row.split(Comms.DELIM);
			books.add(
				new BookModel(Integer.parseInt(values[0]), // id
					values[1], // title
					values[2], // author
					Integer.parseInt(values[3]), // in-stock
					values[4], // publication date
					values[5], // ISBN
					values[6], // country
					values[7], // type
					values[8]  // language
					)
			);
		}
		
		return books;
	}
	
	public CDModel getCD(String field, String param)
	{
		String message = Comms.CDS_MSG + field + Comms.DELIM + param;
		sendRequest(message);
		String[] values = results.get(0).split(Comms.DELIM);
		
		return new CDModel(Integer.parseInt(values[0]), // id
				Integer.parseInt(values[1]), // in-stock
				values[2], // title
				values[3], // country 
				values[4], // type
				values[5], // language
				values[6], // country
				values[7]  // type
		);
	}
	
	public List<CDModel> getAllCDs()
	{
		sendRequest(Comms.CDS_ALL);
		List<CDModel> cds = new LinkedList<>();
		
		for (String row : results)
		{
			String[] values = row.split(Comms.DELIM);
			cds.add(
				new CDModel(Integer.parseInt(values[0]), // id
					Integer.parseInt(values[1]), // in-stock
					values[2], // title
					values[3], // country 
					values[4], // type
					values[5], // language
					values[6], // country
					values[7]  // type
				)
			);
		}
		
		return cds;
	}
}
