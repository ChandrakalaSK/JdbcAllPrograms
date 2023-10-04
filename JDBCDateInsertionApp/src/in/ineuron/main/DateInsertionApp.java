package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil1;

public class DateInsertionApp {

	public static void main(String[] args) 
	{
		//Resources used
		Connection connection = null;
		PreparedStatement pstmt =null;
		Scanner scanner = null;
		
		//variables used
		Integer id=null;
		String name = null;
		String dob = null;
		String dom = null;
		java.sql.Date sqlDob=null;
		java.sql.Date sqlDom=null;
		try {
			connection=JdbcUtil1.getConnection();
			
			String InserSqlQuery="insert into matrimony(id,name,dob,dom)values(?,?,?,?)";
			if(connection != null)
			pstmt=connection.prepareStatement(InserSqlQuery);
			
			if(pstmt != null)
			{
				scanner = new Scanner(System.in);
				if(scanner != null)
				{
					
					System.out.print("Enter the id      ::"); 
					id=scanner.nextInt();
					System.out.print("Enter the username      ::");
					name=scanner.next();
					System.out.print("Enter the dateOfBirth   ::(MM-dd-yyyy)");
					dob=scanner.next();
					System.out.print("Enter the dateOfMarriage::(yyyy-MM-dd)");
					dom=scanner.next();
				}
				
				if(dob != null) {
				//Conversion of String to sqlDate
				SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
				java.util.Date uDate=sdf.parse(dob);
				
				long value=uDate.getTime();
				sqlDob=new java.sql.Date(value);
				}
				if( dom!= null)
				 sqlDom=java.sql.Date.valueOf(dom);
				
				//Set the input values to query
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.setDate(3,sqlDob);
				pstmt.setDate(4,sqlDom);
				
				//execute the query
				int count=pstmt.executeUpdate();
				System.out.println("No of row/s affected:: "+count);
				
				
			}
			} 
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
