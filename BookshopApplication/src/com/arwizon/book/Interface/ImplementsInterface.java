package com.arwizon.book.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.arwizon.bookinfo.BookInfo;
//import com.arwizon.bookinfo.BookInfo;
import com.arwizon.book.main.Connectionclass;

//import com.arwizon.main.ConnectIonclass;

public class ImplementsInterface implements Interface{
	
	public void addBook(String bookCategory,String bookName,String authorName,int units,double cost)
	{
		Connection con=Connectionclass.connectionDb();
		ResultSet rs=null; 
		PreparedStatement stmt=null;
		try {
		String sql1="select max(Book_Id) from Book";
		PreparedStatement stmt1=con.prepareStatement(sql1);
		rs=stmt1.executeQuery();
		int i=500;
		while(rs.next()) {
			i=rs.getInt(1);
			String sql="insert into Book values(?,?,?,?,?,?)";
			stmt=con.prepareStatement(sql);
		    //Customer c=new Customer();
			stmt.setInt(1,i+1);
			stmt.setString(2,bookCategory);
			stmt.setString(3,bookName);
			stmt.setString(4,authorName);
			stmt.setInt(5,units);
			stmt.setDouble(6,cost);
			stmt.executeUpdate();
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public Map<Integer, BookInfo> Checkbook(int Id) {
		
		// TODO Auto-generated method stub
		Map<Integer,BookInfo> m=new HashMap<Integer,BookInfo>();
		
		Connection con=Connectionclass.connectionDb();
		String sql="select * from Book WHERE Book_Id=?";
		ResultSet rs=null; 
		PreparedStatement stmt=null;
		try {
	     	stmt=con.prepareStatement(sql);
			stmt.setInt(1,Id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				
				BookInfo c=new BookInfo();
				c.setBookid(rs.getInt(1));
				c.setBookCategory(rs.getString(2));
				c. setBookName(rs.getString(3));
				c.setAuthorName(rs.getString(4));
				c.setUnits(rs.getInt(5));
				c.setCost(rs.getDouble(6));
				m.put(Id,c);
				}
		}
			
		
			catch(SQLException e) {
				e.printStackTrace();
			}
		finally
		{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return m;
		//return null;
	}

	@Override
	public void Updatebook(int bookid, int newUnits) {
		// TODO Auto-generated method stub
		Connection con=Connectionclass.connectionDb();
		String sql="update Book SET Bookunits=? WHERE Book_Id=?";
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1,newUnits );
			stmt.setInt(2,bookid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
			//	rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}
