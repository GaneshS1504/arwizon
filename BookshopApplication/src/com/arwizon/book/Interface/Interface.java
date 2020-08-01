package com.arwizon.book.Interface;

import java.util.Map;

import com.arwizon.bookinfo.BookInfo;
//import com.arwizon.bookinfo.BookInfo;

public interface Interface {
	public  void addBook(String bookCategory,String bookName,String authorName,int units,double cost);
	public Map<Integer,BookInfo> Checkbook(int Id);
	public void Updatebook(int bookid,int newUnits);

}
