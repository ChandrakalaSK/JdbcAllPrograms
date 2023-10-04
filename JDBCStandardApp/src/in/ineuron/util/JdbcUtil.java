package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {
		
	}
	static {
		//Step 1:Loading and register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load the driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	public static Connection getJdbConnection() throws SQLException, IOException
	{
		
		//Take the data from properties file
		FileInputStream fis=new FileInputStream("D:\\JDBCPGM\\JDBCStandardApp\\application.properties");
		//location we need to pass
		Properties properties = new Properties();
		properties.load(fis);
		
//		String url ="jdbc:mysql:///octbatch";
//		String user="root";
//		String password="root";
		/* Connection connection=DriverManager.getConnection(url, user, password); */
		//inline code alt+shift+i and seclect variable name eg:url
		Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
		System.out.println("Connection object is created");
		return connection;
	}
	public static void cleanUp(Connection con,Statement statement,ResultSet resultSet) throws SQLException
	{
		//Step 6:Close the resources
		if(con != null)
		{
			con.close();
		}
		if(statement != null)
		{
			statement.close();
		}
		if(resultSet != null)
		{
			resultSet.close();
		}
	}

}
