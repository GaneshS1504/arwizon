package com.arwizon.book.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.arwizon.book.Interface.ImplementsInterface;
import com.arwizon.book.Interface.Interface;
import com.arwizon.bookinfo.BookInfo;

public class Main {
	static int ch;
	public static void main(String[] Args)
	{
		
		Connectionclass.connectionDb();
		System.out.println("press 1 to  add books  data");
		System.out.println("press 2 to display books data");
		System.out.println("press 3 to search books  data");
		System.out.println("press 4 to to update books data");
		
		//Scanner data=new Scanner(System.in);
	    System.out.println("enter how many books data you want to enter");
        //int n=data.nextInt();
        //Customer[] arr=new Customer[n];
	   Map<Integer,BookInfo> hm=new TreeMap<Integer,BookInfo>();
	   
		while(true)
		{
			
			Scanner read=new Scanner(System.in);
			System.out.println("enter your choice");
			ch=read.nextInt();
			//Customer C=new Customer();
			switch(ch)
			{
			      
			case 1:
				 
				        System.out.println("enter book category ");
				        String bookCategory=read.next();
				        System.out.println("enter book name");
				        String bookName=read.next();
				        System.out.println("enter book author name");
				        String authorName=read.next();
				        System.out.println("enter no of books availabel");
				        int units=read.nextInt();
				        System.out.println("enter book price");
				        int cost=read.nextInt();
				        Interface book=new ImplementsInterface();
				       book.addBook(bookCategory,bookName,authorName,units,cost);
				       // hm.put(Customer.getCount(),c1);
				    
				
			  break;
				
			
			case 2:
				Connection con=Connectionclass.connectionDb();
				String sql="select * from Book";
				try {
		     	PreparedStatement stmt=con.prepareStatement(sql);
		     	//Customer c=new Customer();
		     	ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					
					BookInfo b1=new BookInfo();
					Set<BookInfo> s=new HashSet<BookInfo>();
					b1.setBookid(rs.getInt(1));
					b1.setBookCategory(rs.getString(2));
					b1.setBookName(rs.getString(3));
					b1.setAuthorName(rs.getNString(4));
					b1.setUnits(rs.getInt(5));
					b1.setCost(rs.getDouble(6));
					s.add(b1);
					System.out.println(s);
					
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			  
			case 3:
				System.out.println("enter Book id to search");
				int Id=read.nextInt();
				Interface i=new ImplementsInterface();
				Map<Integer,BookInfo> cust=i.Checkbook(Id);
				if(cust.isEmpty()) {
					System.out.println("Book Not Found");
				}
				else
				{
					System.out.println(cust);
				}
				break;
			case 4:
				System.out.println("enter the Book Id to be Updated");
				
				int bookid=read.nextInt();
				
				Interface j=new ImplementsInterface();
				System.out.println("enter the updated units of books");
				int newUnits=read.nextInt();
				
				j.Updatebook(bookid,newUnits);
				
				
				break;
		
				
		    case 5:
	           System.exit(1);
	           
			
			}
			
		}
		
	}


}
