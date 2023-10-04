package com.ineuron.util;

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
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException ce) 
			   {
				ce.printStackTrace();
			   	}
		}
		
		public  static Connection getJdbcConnection() throws SQLException, IOException
		{
		FileInputStream fis = new FileInputStream("D:\\JDBCPGM\\JDBCCrudApp\\src\\in\\ineuron\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		//System.out.println("Connection object is created");
		return connection;
		}
		
		public static void cleanUp(Connection con,Statement statement,ResultSet resultSet) throws SQLException
		{
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


