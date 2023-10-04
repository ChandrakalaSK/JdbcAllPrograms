package in.ineuron.service;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;

//service layer logic
public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao stdDao;
	
	IStudentService stdService;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao=StudentDaoFactory.getStudentDao();
		if(stdDao != null)
			return stdDao.addStudent(sname, sage, saddress);
		else
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
