package in.ineuron.servicefactory;


import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

//Connection connection=Drivermnager.getConnection(url,username,password);
 	
public class StudentServiceFactory {
	//Make constructor private to avoid object creation
	//Abstraction class of implementation
	private  StudentServiceFactory() {
		}
	private static IStudentService studentService = null;
	
	//Singleton pattern code
	
	public static IStudentService getStudentService()
	{
		if(studentService == null) 
		{
		studentService = new StudentServiceImpl();
		}
		return studentService;
		
	}

}
