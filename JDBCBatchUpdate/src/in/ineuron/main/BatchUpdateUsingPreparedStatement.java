package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import in.ineuron.util.JdbcUtil1;

public class BatchUpdateUsingPreparedStatement {

	public static void main(String[] args) 
	{
		//Resources used
		Connection connection = null;
		PreparedStatement pstmt =null;
		Scanner scanner = null;
		
		
		
		try {
			String sqlInsertQuery="insert into employees(`name`,`age`,`address`)values(?,?,?)";
			connection=JdbcUtil1.getConnection();
			if(connection != null)
				pstmt=connection.prepareStatement(sqlInsertQuery);
			if(pstmt != null)
			{
				scanner = new Scanner(System.in);
				while (true) {
					System.out.print("Enter the name::");
					String name=scanner.next();
					System.out.print("Enter the age::");
					int age=scanner.nextInt();
					System.out.print("Enter the address::");
					String address=scanner.next();
				
					//Set the values
					pstmt.setString(1,name);
					pstmt.setInt(2,age );
					pstmt.setString(3,address);
					
					//Query added to a batch file
					pstmt.addBatch();
					System.out.print("Do you want to add one more record[YES/NO]");
					String option=scanner.next();
					
					if(option.equalsIgnoreCase("no"))
					{
						break;
					}
			}
				//Executing the queries present in batch file
				pstmt.executeBatch();
				System.out.println("Records inserted successfully");
			
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
