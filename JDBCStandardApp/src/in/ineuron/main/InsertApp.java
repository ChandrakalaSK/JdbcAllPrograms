package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import in.ineuron.util.JdbcUtil;

public class InsertApp {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement   = null;
		ResultSet resultSet   = null;
		
		try {
			connection=JdbcUtil.getJdbConnection();
			if(connection != null)
				statement=connection.createStatement();
			if(statement != null)
				resultSet=statement.executeQuery("select name,age,address from student");
			if(resultSet != null) {
				System.out.printf("%-2s%14s%10s","NAME","AGE","ADDRESS");
				while (resultSet.next()) {
					//inline code Alt+Shit+i
					System.out.printf("%-2s%d%8s",resultSet.getString(1),resultSet.getInt(2),resultSet.getString(3));
					
				}
			}
		} 
		catch (IOException io) {
			io.printStackTrace();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.cleanUp(connection, statement, resultSet);
				System.out.println("Closing the resources");
			} catch (SQLException se) {
				se.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		
		
		

		

		

		


	}

}
