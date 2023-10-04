package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtil1 {
	
	private JdbcUtil1() {
		}
	static {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws IOException, SQLException
	{
		
		FileInputStream fis = new FileInputStream("src\\in\\ineuron\\properties\\application.properties");
		Properties properties =new Properties();
		properties.load(fis);
		Connection connection = null;
	    connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		
		return connection;
	}
	public static void cleanUp(Connection con,Statement stmt,ResultSet resultSet) throws SQLException
	{
		if(con != null)
		{
			con.close();
		}
		if(stmt != null)
		{
			stmt.close();
		}
		if(resultSet != null)
		{
			resultSet.close();
		}
		
	}
	

	

}
