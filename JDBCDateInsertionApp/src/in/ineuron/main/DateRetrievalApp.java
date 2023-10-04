package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import in.ineuron.util.JdbcUtil1;

public class DateRetrievalApp {

	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet =null;
		int id =1;
		 try {
			connection=JdbcUtil1.getConnection();
			String selectQuery="select id,name,dob,dom from matrimony where id =?";
			
			if(connection != null)
			{
				pstmt=connection.prepareStatement(selectQuery);
			}
			
			if(pstmt != null)
			{
				//Setting input values
				pstmt.setInt(1,id);
				
				//Executing query
				resultSet=pstmt.executeQuery();
			}
			if(resultSet != null)
			{
				//Processing the resultSet()
				if(resultSet.next())
				{
					System.out.println("SID\tSNAME\tSDOB\tSDOM");
					int sid = resultSet.getInt(id);
					String sname=resultSet.getString(2);
					java.sql.Date sdob=resultSet.getDate(3);
					java.sql.Date sdom=resultSet.getDate(4);
				//	System.out.println(sid +"\t" + sname +"\t" +sdob +"\t" +sdom);
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					String strDob=sdf.format(sdob);
					String strDom=sdf.format(sdom);
					System.out.println(sid +"\t" + sname +"\t" +strDob +"\t" +strDom);
				}
				else
				{
					System.out.println("Record not available for the given id::"+id);
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		 catch( SQLException se)
		 {
			 se.printStackTrace();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally {
			try {
				JdbcUtil1.cleanUp(connection,pstmt,resultSet);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}

	}

}
