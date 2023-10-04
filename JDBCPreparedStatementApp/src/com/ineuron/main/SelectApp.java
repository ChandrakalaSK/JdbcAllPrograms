package com.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcUtil;

public class SelectApp {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet resultSet = null;
		try {
			
			con = JdbcUtil.getJdbcConnection();
			String sqlSelectQuery="select name,age,address from student where name=?";
			if(con != null)
			pstmt=con.prepareStatement(sqlSelectQuery);
			if(pstmt != null)
			{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the name of the student::");
			String name=scan.next();
			//use pre-compiled query
			pstmt.setString(1, name);
	
			//Execute the query
			resultSet=pstmt.executeQuery();
			scan.close();
			}
		 
		if(resultSet != null) {
			if(resultSet.next()) {
				System.out.println("NAME\tAGE\tADRESS");
				System.out.println(resultSet.getString(1)+ "\t" +resultSet.getInt(2)+ "\t" +resultSet.getString(3));
			}
			else
			{
				System.out.println("Records not found");
			}
			}
		}
		
				
			
	
			catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException io) {
			
			io.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				JdbcUtil.cleanUp(con, pstmt, resultSet);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

}
