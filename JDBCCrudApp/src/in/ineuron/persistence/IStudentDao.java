package in.ineuron.persistence;

import in.ineuron.dto.Student;

public interface IStudentDao 
{
	//Operation to be implemented
	public String addStudent(String sname,Integer sage,String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
	
	public String DeleteStudent(Integer sid);

}
