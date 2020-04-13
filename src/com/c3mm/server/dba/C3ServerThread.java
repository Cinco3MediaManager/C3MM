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
	
	public void run()
	{
		try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			String inputLine, outputLine;
			DBAProtocol dbap = new DBAProtocol();
			outputLine = dbap.processInput(null);
			out.println(outputLine);
			
			while ((inputLine = in.readLine()) != null)
			{
				outputLine = dbap.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.equals("done"))
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
