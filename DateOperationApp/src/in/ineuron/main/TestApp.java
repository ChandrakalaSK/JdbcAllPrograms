package in.ineuron.main;

import java.sql.Date;



public class TestApp {

	public static void main(String[] args) 
	{
		//java.util.Date ->We use to store both Date and Time information
		java.util.Date udate = new java.util.Date();
		System.out.println("util Date is ::"+udate);
		
		
		long value= udate.getTime();
		System.out.println("Information about date in milliseconds::"+value);
		
		
		//java.sql.Date->We use to store Date information
		java.sql.Date sqlDate = new Date(value);
		System.out.println("sqlDate is::"+sqlDate);
		
		
		

	}

}
