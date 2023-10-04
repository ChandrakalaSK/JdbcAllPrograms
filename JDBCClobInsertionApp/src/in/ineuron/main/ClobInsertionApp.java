package in.ineuron.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import in.ineuron.util.JdbcUtil1;

public class ClobInsertionApp {

	public static void main(String[] args) 
	{
		//Resources used
		Connection connection = null;
		PreparedStatement pstmt =null;
		Scanner scanner = null;
		
		//Variables used
		Integer id = null;
		String city=null;
		String pdfLocation=null;
		
		try {
			connection=JdbcUtil1.getConnection();
			
			//String InserSqlQuery="insert into persons(name,image)values(?,?)";
			String InserSqlQuery="insert into cities(`id`,`name`,`history`)values(?,?,?)";
			if(connection != null)
			pstmt=connection.prepareStatement(InserSqlQuery);
			
			if(pstmt != null)
			{
				scanner = new Scanner(System.in);
				if(scanner != null)
				{
					System.out.print("Enter the id::");
					 id=scanner.nextInt();
					
					System.out.print("Enter the City name::");
					 city=scanner.next();
					
					System.out.print("Enter the pdfLocation::");
					 pdfLocation=scanner.next();
				}
				//Set the input values to query 
				pstmt.setInt(1, id);
				pstmt.setString(2,city);
				pstmt.setCharacterStream(3,new FileReader(new File(pdfLocation)));
				
				//execute the query
				int count=pstmt.executeUpdate();
				System.out.println("No of row/s affected:: "+count);
				
				
		}
			} 
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			try {
				JdbcUtil1.cleanUp(connection, pstmt, null);
				scanner.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

}
