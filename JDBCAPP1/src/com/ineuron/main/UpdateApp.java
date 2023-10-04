package com.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateApp {

	public static void main(String[] args) throws SQLException
	{
	
		//Step 1:Establish the connection
		String url="jdbc:mysql:///octbatch";
		String user="root";
		String password="root";
		Connection connection=DriverManager.getConnection(url,user,password);
		System.out.println("Connection object is cretaed"+connection.getClass().getName());
		
		//Step 2:create Statement object and send the query
		Statement statement=connection.createStatement();
		System.out.println("Statement object is cretaed"+statement.getClass().getName());
		
		//Step3 :Execute the query and process the result
		String updateQuery="Update coffeemachinetable set Coffee_Name='TAJ' where Coffee_ID=1";
		int count=statement.executeUpdate(updateQuery);
		System.out.println("No of row/s affected:"+count);
		
		//Step 4:Closing the connection
		statement.close();
		connection.close();
		
	}

}
