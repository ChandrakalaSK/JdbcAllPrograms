package com.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//JDBC4.X autoloading feature is enabled
public class SelectApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
//		//Step1:Load and register the driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Load and register the driver");
		
		//Step 2:Create connection object
		String url ="jdbc:mysql:///octbatch";
		String user = "root";
		String password ="root";
	    Connection connection= DriverManager.getConnection(url,user,password);
	    
	    //Step 3:Create Statement object and send the query
	    
	    Statement statement=connection.createStatement();
	    
	    //Step 4:Execute the query and process the result
	    String query ="select Coffee_ID,Coffee_Name,Supplier_ID,price,Sales,Total from coffeemachinetable";
	    ResultSet resultSet=statement.executeQuery(query);
	    
	    System.out.println("Cofe_ID\tCofe_Name\tSpl_ID\tprice\tSales\tTotal");
	    while(resultSet.next()) {
	    int Coffee_ID =resultSet.getInt(1);
	    String Coffee_Name=resultSet.getString(2);
	    int Supplier_ID=resultSet.getInt(3);
	    float price=resultSet.getFloat(4);
	    int Sales=resultSet.getInt(5);
	    int Total= resultSet.getInt(6);
	    System.out.println(Coffee_ID +"\t"+Coffee_Name+"\t"+Supplier_ID+"\t"+price+"\t"+Sales+"\t"+Total);
	    }  
	    //Step 5:Close the resources
	    resultSet.close();
	    statement.close();
	    connection.close();
	
	}

}
