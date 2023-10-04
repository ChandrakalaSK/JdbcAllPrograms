package in.ineuron.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.util.JdbcUtil;

import in.ineuron.dto.Student;

//Persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {
	
	Connection connection  = null;
	PreparedStatement pstmt =null;
	Scanner scanner = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		try {
			String sqlInsertQuery="insert into student(`name`,`age`,`address`)values(?,?,?)";
			connection=JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				connection.prepareStatement(sqlInsertQuery);
			}
			if(pstmt != null)
			{								
				pstmt.setString(1,sname);
				pstmt.setInt(2,sage);
				pstmt.setString(3,saddress);
				
				int count=pstmt.executeUpdate();
				if(count == 1)
				{
					return"success";
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
	
		return null;
	}

	@Override
	public String DeleteStudent(Integer sid) {
	
		return null;
	}

}
