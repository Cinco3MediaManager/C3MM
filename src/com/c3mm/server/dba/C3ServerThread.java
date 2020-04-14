package com.c3mm.server.dba;
import java.net.*;
import java.io.*;

public class C3ServerThread extends Thread
{
	private Socket socket = null;
	
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
				outputLine = dbap.processInput(inputLine); // get the server's response to the clients request
				out.println(outputLine); // send the response to the client
				if (outputLine.equals("done")) // if server response is done quit loop close connection
					break;
			}
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
