package com.c3mm.server.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class C3DBA
{
	private static final String NOT_FOUND = "no results found";
	private static final String C3DB = "jdbc:sqlite:c3db.db"; // database url
	private Connection con = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String result = "";
	
	public String getBook(String table, String param)
	{
		try
		{
			con = DriverManager.getConnection(C3DB);
			String sql = "select * from "+ table + " where isbn = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, param);
			
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			if (rs.next() == false)
			{
				System.out.println(NOT_FOUND + "args: " + param);
				result = NOT_FOUND + " --> args: " + param;
			}
			else
			{
				do
				{
					for (int i = 1; i <= numberOfColumns; i++)
					{
						result = result + rs.getString(i) + ";";
					}
				}
				while (rs.next());
			}
			
			if (stmt != null)
			{
				stmt.close();
			}
			
			if (con != null)
			{
				con.close();
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
}
