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
		public static String getBook(String isbn)
		{
			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Vector<String> values = new Vector<String>();
			String result = "";
			try
			{
				String url = "jdbc:sqlite:C:\\db\\media\\media.db";
				con = DriverManager.getConnection(url);
				String sql = "select * from books where isbn = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, isbn);
				
				rs = stmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				int numberOfColumns = rsmd.getColumnCount();
				
				if (rs.next() == false)
				{
					System.out.println("Query Returned no results");
				}
				else
				{
					do
					{
						for (int i = 1; i <= numberOfColumns; i++)
						{
							values.add(rs.getString(i));
						}
					}while (rs.next());
				}
				
				for (int i=0; i<values.size(); i++)
				{
					result = result + values.get(i) + ";"; 
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