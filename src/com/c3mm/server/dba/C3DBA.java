package com.c3mm.server.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class C3DBA
{
	private static final String NOT_FOUND = "no results found";
	private static final String C3DB = "jdbc:sqlite:c3db.db"; // database url
	private static final String SEL_ALL_FROM = "select * from ";
	private static final String WHERE = " where ";
	private static final String EQUALS = " = ?";
	
	private Vector<String> rows = new Vector<String>();
	
	public void select(String table, String field, String value)
	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(C3DB);
			String sql = buildQuery(table, field, value);
			stmt = con.prepareStatement(sql);
			
			if (!value.isEmpty())
				stmt.setString(1, value);
			
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			if (rs.next() == false)
			{
				System.out.println(NOT_FOUND + "args: " + value);
			}
			else
			{
				do
				{
					String row = "";
					for (int i = 1; i <= numberOfColumns; i++)
					{
						row = row + rs.getString(i) + ";";
					}
					rows.add(row);
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
	}
	
	private String buildQuery(String table, String field, String value)
	{
		if (value.isEmpty())
		{
			return SEL_ALL_FROM + table;
		}
		else
		{
			return SEL_ALL_FROM + table + WHERE + field + EQUALS;
		}
	}
	
	public void getBook(String table, String param)
	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String result = "";
		
		try
		{
			con = DriverManager.getConnection(C3DB);
			String sql = "select * from " + table + " where isbn = ?";
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
					rows.add(result);
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
		
	}
	
	public Vector<String> getBooks()
	{
		Vector<String> rows = new Vector<String>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			conn = DriverManager.getConnection(C3DB);
			
			String sql = "select * from books";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			while (rs.next())
			{
				String row = "";
				for (int i = 1; i <= numberOfColumns; i++)
				{
					row = row + rs.getString(i) + ";";
				}
				rows.add(row);
			}
			
			if (stmt != null)
			{
				stmt.close();
			}
			
			if (conn != null)
			{
				conn.close();
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	
	public Vector<String> getRows()
	{
		return rows;
	}
	
	public void setRows(Vector<String> rows)
	{
		this.rows = rows;
	}

	public void update(String table, String field, String value)
	{
		// TODO Auto-generated method stub
		
	}

	public void insert(String table, String field, String value)
	{
		// TODO Auto-generated method stub
		
	}
	
}
