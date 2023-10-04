package com.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlDynamicInput {

	public static void main(String[] args)throws SQLException
	{
		// Step2. Establish the Connection
				String url = "jdbc:mysql:///octbatch";
				String user = "root";
				String password = "root";
				Connection connection = DriverManager.getConnection(url, user, password);
				System.out.println("connection object created...");

				// Step3. Create statement Object and send the Query
				Statement statement = connection.createStatement();
				System.out.println("statement object created...");

				Scanner scanner = new Scanner(System.in);

				System.out.print("Enter the name of the student :: ");
				String name = scanner.next();

				System.out.print("Enter the age of the student :: ");
				int age = scanner.nextInt();

				System.out.print("Enter the address of the student :: ");
				String address = scanner.next();
				
				

				// Step4. Execute the Query and Process the resultSet
				String sqlInsertQuery = String.format("insert into student(`name`,`age`,`address`) values ('%s',%d,'%s')",
																			name, age, address);

				System.out.println(sqlInsertQuery);

				int rowAffected = statement.executeUpdate(sqlInsertQuery);
				System.out.println("No of rows affected is :: " + rowAffected);

				// Step6. Close the resources
				statement.close();
				connection.close();
				scanner.close();
				System.out.println("closing the resources...");

	}

}
