package com.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		//Step 2:Establish the connection 
		String url="jdbc:mysql:///octbatch";
		String user="root";
		String password="root";
		Connection connection = DriverManager.getConnection(url,user,password);
		
		//Step 2:Create Statement object and send the query
		Statement statement=connection.createStatement();

		//Step 3:Execute  the query and process the result
		String deleteQuery ="delete from coffeemachinetable where Coffee_ID=2";
		int count=statement.executeUpdate(deleteQuery);
		System.out.println("No of row/s affected" +count);
		
		//Step 4:Close the resources
		statement.close();
		connection.close();
	}

}
