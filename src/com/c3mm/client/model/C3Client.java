package com.c3mm.client.model;
import java.io.*;
import java.net.*;
import java.util.Vector;

public class C3Client
{
	/* Constants for program configuration */
	private static final String NOT_FOUND = "no results found";
	private static final String DONE = "done.";
	private static final String DELIMITER = ";"; // string delimiter to break the server's response into an array
	private static final String SERVER = "Server-> ";
	private static final String CLIENT = "Client-> ";
	private static final String UNKNOWN_HOST = "The specified host could not be found: ";
	private static final String IO_HOST = "Couldn't get I/O for the connection to ";
	private static final String HOST = "localhost"; //change to connect across computers
	private static final int PORT = 4000; //change to connect across computers
	
//	private String[] values = null;
	Vector<String> results = new Vector<String>();
	
	private void sendRequest(String table, String value)
	{
		try (Socket socket = new Socket(HOST, PORT); // connect to the server socket. 
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // use this to send requests to server
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) // use this to read response from server 
		{
			String fromServer;
			String fromClient;
			
			// This loop executes every time the server sends a response
			while ((fromServer = in.readLine()) != null) // read from the server
			{
				System.out.println(SERVER + fromServer); // tell me what the server said
				
				if ( fromServer.equals(DONE) ) // if the server sends "done.", exit the loop and close connection
					break;
				
				if( fromServer.contains(NOT_FOUND) ) // if the query returns no results
					break;
				
				if( fromServer.contains(DELIMITER) )
				{
					results.add(fromServer);
					
//					values = fromServer.split(DELIMITER); // get the values returned by query and split them into an array then break the loop
				}
				
				if( fromServer.equals("single"))
				{
					break;
				}
//				
				fromClient = table + DELIMITER + value; // concatenate the params needed for query
//				fromClient = "books;all"; // concatenate the params needed for query
				
				
				if (fromClient != null)
				{
					System.out.println(CLIENT + fromClient); // show me what I am sending to the server
					out.println(fromClient); // send it to the server
//					sent = true;
					
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
	
//	public String[] getValues()
//	{
//		return values;
//	}

	public Vector<String> getResults() {
		return results;
	}

	public void setResults(Vector<String> results) {
		this.results = results;
	}

	public BookModel getModel(String table, String param) {
		
		sendRequest(table, param);
		
		String[] values = results.get(0).split(DELIMITER);
				
		return new BookModel(
				Integer.parseInt(values[0]), //id
				values[1], //title 
				values[2], //author
				Integer.parseInt(values[3]), //in-stock
				values[4], //publication date
				values[5], //ISBN
				values[6], //country
				values[7], //type
				values[8]  //language
			);
	}
}
