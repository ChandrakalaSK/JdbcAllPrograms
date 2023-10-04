package in.ineuron.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.commons.io.IOUtils;

import in.ineuron.util.JdbcUtil1;

public class ImageRetrievalApp {

	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet =null;
		int id =1;
		 try {
			connection=JdbcUtil1.getConnection();
			String selectQuery="select id,name,image from persons where id =?";
			
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
					System.out.println("SID\tSNAME\tIMAGE");
					int sid = resultSet.getInt(1);
					String sname=resultSet.getString(2);
					InputStream is=resultSet.getBinaryStream(3);
					
					
					File file = new File("copied.jpg");
					FileOutputStream fos=new FileOutputStream(file);
					
					//coping data from is to fos
					IOUtils.copy(is, fos);
					
					/*
					 * int i=is.read(); while (i != -1) { fos.write(i); i=is.read(); }
					 */
					/*
					 * byte[] b = new byte[1024]; while (is.read(b)>0) { fos.write(b); }
					 */
					
					fos.close();
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
