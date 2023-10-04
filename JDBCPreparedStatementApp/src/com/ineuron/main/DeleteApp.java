package com.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcUtil;

public class DeleteApp {

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("Connection estblished");
		try {
			String deleteSqlQuery ="Delete from student where age=?";
			con = JdbcUtil.getJdbcConnection();
			
			if(con != null)
			 pstmt = con.prepareStatement(deleteSqlQuery);
			
			if( pstmt != null)
			{
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the age of the student::");
				int age=scanner.nextInt();
				scanner.close();
				
				pstmt.setInt(1, age);
				
			int count = pstmt.executeUpdate();
			System.out.println("No of row/s affected::"+count);
			}
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}catch (SQLException e) {
			
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.cleanUp(con, null, null);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		

	}

}
