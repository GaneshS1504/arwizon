package com.arwizon.bookinfo;

public class BookInfo {
	static int  count=1003;
	private String bookCategory;
	private String bookName ;
	private int bookId;
	private String authorName;
	private int units;
	private double cost;
	
	public BookInfo()
	{
		count++;
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public void setBookid(int bookId)
	{
		this.bookId=bookId;
	}
	    public String getBookCategory() {
			return bookCategory;
		}

		public void setBookCategory(String bookCategory) {
			this.bookCategory = bookCategory;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		public int getUnits() {
			return units;
		}

		public void setUnits(int units) {
			this.units = units;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}
		public String toString()
		{
			return "bookid:"+this.bookId+"Bookcategory"+":"+this.bookCategory+" "+"bookname:"+this.bookName+" "+"authorname:"+this.authorName+" "+"quantity:"+this.units+" "+"bookprice:"+this.cost;
			
		}


}
