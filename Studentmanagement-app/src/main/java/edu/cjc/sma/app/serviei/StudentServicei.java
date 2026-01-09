package edu.cjc.sma.app.serviei;

import java.util.List;

import edu.cjc.sma.app.model.Student;

public interface StudentServicei {

	

	public void saveStudentDetails(Student stu);

	 public List<Student> getAllStudents();
	 
	 public List<Student> searchStudentsByBatch(String batchNumber,String batchMode);

	 public void deleteStudentById(int studentId);

	 public Student getSingleStudent(int studentId);

	 public void updateStudentFees(int studentId, Double ammount);

	 
}
