package in.ineuron.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.io.IOUtils;

import in.ineuron.util.JdbcUtil1;

public class ClobRetrievalApp {

	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet =null;
		int id =1;
		 try {
			connection=JdbcUtil1.getConnection();
			String selectQuery="select id,name,history from cities where id =?";
			
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
					System.out.println("SID\tSNAME\tHISTORY");
					int sid = resultSet.getInt(1);
					String sname=resultSet.getString(2);
					Reader reader=resultSet.getCharacterStream(3);
					
					
					File file = new File("History_copied.txt");
					FileWriter writer=new FileWriter(file);
					
					//coping data from is to fos
					IOUtils.copy(reader,writer);
					
					/*
					 * int i=is.read(); while (i != -1) { fos.write(i); i=is.read(); }
					 */
					/*
					 * byte[] b = new byte[1024]; while (is.read(b)>0) { fos.write(b); }
					 */
					
					writer.close();
					System.out.println(sid +"\t" + sname +"\t" + file.getAbsoluteFile());
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
