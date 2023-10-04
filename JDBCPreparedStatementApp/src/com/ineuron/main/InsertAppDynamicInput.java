package com.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

import com.ineuron.util.JdbcUtil;

public class InsertAppDynamicInput {

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner scanner =null;
	
		
		try {
			  con=JdbcUtil.getJdbcConnection();
			  
			  System.out.println("Connection established");
			  
			  String sqlInsertDynamicInput="insert into student(`name`,`age`,`address`)values(?,?,?)"; 
			  scanner = new Scanner(System.in); 
			  System.out.println("Enter the name of the student::");
			  String name=scanner.next(); 
			  System.out.println("Enter the age of the age::");
			  int age=scanner.nextInt();
			  System.out.println("Enter the address of the student::"); 
			  String address=scanner.next(); 
			  con=JdbcUtil.getJdbcConnection(); 
			  if(con != null)
			  pstmt=con.prepareStatement(sqlInsertDynamicInput); 
			  pstmt.setString(1,name);
			  pstmt.setInt(2, age); 
			  pstmt.setString(3, address);
			  int count=pstmt.executeUpdate();
			  System.out.println("No of row/s affected::"+count);
			  System.out.println(sqlInsertDynamicInput);
			 
			
		} catch (IOException io)
		{
			io.printStackTrace();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try 
			{
				JdbcUtil.cleanUp(con,pstmt, null);
				scanner.close();
				 
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
