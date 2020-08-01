package com.arwizon.book.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;

public class Connectionclass {
	 private static String url="jdbc:mysql://localhost:3306/arwizon";
	 private static String username="root";
	 private static String pass="gaNESH@15";
	public static Connection connectionDb()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con=DriverManager.getConnection(url,username,pass);
			con=DriverManager.getConnection(url,username,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}


}
