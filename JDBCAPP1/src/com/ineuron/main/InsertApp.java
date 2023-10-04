package com.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		//ResultSet resultSet = null;
		try {
			//Step 1:Load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and register the driver");
			//Step 2:Create connection object
			String url = "jdbc:mysql:///octbatch";
			String userName = "root";
			String password = "root";
			connection=DriverManager.getConnection(url,userName,password);
			//Step 3:Create Statement and send the query
			statement=connection.createStatement();
			String insertQuery="insert into coffeemachinetable values(003,'NessCaffee',003,1350.30,700,53415)";
			
			//Step 4:Execute the query and process the resultSet
			int count=statement.executeUpdate(insertQuery);
			System.out.println(count+"row/s affected");
			
			//Step 5:Handle exception if any
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		//Step 6:Close the connection
		finally {
			if(connection != null)
			{
				try {
					connection.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		

	}

}
