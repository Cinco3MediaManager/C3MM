package com.c3mm.server.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.c3mm.client.model.BookModel;
import com.c3mm.client.view.Columns;

public class MediaDB
{
	public static BookModel getBook(String isbn)
	{
		BookModel book = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String url = "jdbc:sqlite:C:\\db\\media\\media.db";
			con = DriverManager.getConnection(url);
			String sql = "select * from books where isbn = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			
			rs = stmt.executeQuery();
			
			if (rs.next() == false)
			{
				System.out.println("Query Returned no results");
			}
			else
			{
				do
				{
					book = new BookModel(rs.getInt(Columns.REC_ID), rs.getString(Columns.STATUS),
							rs.getString(Columns.TITLE), rs.getString(Columns.LOCATION), rs.getString(Columns.PUBDATE),
							rs.getString(Columns.ISBN), rs.getString(Columns.AUTHOR));
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
		return book;
	}
}
