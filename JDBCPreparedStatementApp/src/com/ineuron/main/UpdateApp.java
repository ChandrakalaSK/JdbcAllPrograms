package com.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcUtil;

public class UpdateApp {
	

	public static void main(String[] args) 
	{
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 
		try {
		String updateQuery="update Student set name=? where age=? ";
		con=JdbcUtil.getJdbcConnection();
		
		if(con != null)
		pstmt=con.prepareStatement(updateQuery);
		
		if(pstmt !=null)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the name of the student");
			String name=scanner.next();
			
			System.out.println("Enter the age of the student");
			int age=scanner.nextInt();
			
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			
			int count=pstmt.executeUpdate();
			System.out.println("No of row/s affected::"+count);
			scanner.close();
		}
			
		} catch (IOException io) {
			io.printStackTrace();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.cleanUp(con,pstmt, null);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		

	}

}
