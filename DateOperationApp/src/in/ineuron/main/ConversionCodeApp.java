package in.ineuron.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class ConversionCodeApp {

	public static void main(String[] args) throws ParseException 
	{
		//Read the input from user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date:: (dd-MM-yyyy)");
		String sdate=scanner.next();
		
		//Convert the date from String format to java.util.Date
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(sdate);
		//Convert the java.util.Date to java.sql.Date (sql or DB format)
		long value=udate.getTime();
		java.sql.Date sqDate = new java.sql.Date(value);

		//Printing all the 3 formats of Date
		System.out.println("String format date is ::"+sdate);
		System.out.println("Util date is ::"+udate);
		System.out.println("Sql date is::"+sqDate);
		
		//Read the date from user
		System.out.println("Enter the dom in the following format::(yyyy-MM-dd)");
		String standradInput=scanner.next();
		java.sql.Date sqlStandardInput=java.sql.Date.valueOf(standradInput);
		System.out.println("String standardinput ::"+standradInput);
		System.out.println("String sqlStandardinput ::"+sqlStandardInput);
		
		scanner.close();
		
	}

}
