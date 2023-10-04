package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) throws SQLException 
	{
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System", "root");
		//Statement statement=connection.createStatement();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the userName :: ");
		String uname=scanner.next();
		
		System.out.println("Enter the password :: ");
		String upwd=scanner.next();
		
		//String sqlSelectQuery="select count(*) from users where name='"+uname+"' and password ='"+upwd+"'";
		String sqlSelectQuery="select count(*) from users where name=? and password =?";
		System.out.println(sqlSelectQuery);
		//ResultSet resultSet=statement.executeQuery(sqlSelectQuery);
		PreparedStatement pstmt=connection.prepareStatement(sqlSelectQuery);
		pstmt.setString(1,uname);
		pstmt.setString(2,upwd);
		ResultSet resultSet=pstmt.executeQuery();
		int row = 0;
		if(resultSet.next()) {
			row = resultSet.getInt(1);
		}
		if(row == 1)
			System.out.println("valid credentials");
		else
			System.out.println("Invalid crendentials");
		
		scanner.close();
	}

}
