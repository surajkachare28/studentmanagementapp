package edu.cjc.sma.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sma.app.model.Student;
import edu.cjc.sma.app.repository.StudentRepository;
import edu.cjc.sma.app.serviei.StudentServicei;

@Service
public class StudentServiceimpl implements StudentServicei{

	@Autowired
	StudentRepository sr;
	
	@Override
	public void saveStudentDetails(Student stu) {
		
		sr.save(stu);
		
	}
	
	@Override
	public List<Student> getAllStudents()
	{
		return sr.findAll();
	}

	@Override
	public List<Student> searchStudentsByBatch(String batchNumber,String batchMode) {
		
		List<Student> batchStudents=sr.findAllByBatchNumber(batchNumber, batchMode);
		
		return batchStudents;
	}

	@Override
	public void deleteStudentById(int studentId) {
		
		sr.deleteById(studentId);
		
	}

	@Override
	public Student getSingleStudent(int studentId) {
		
		Optional<Student> stu=sr.findById(studentId);
		
		return stu.get();
	}

	@Override
	public void updateStudentFees(int studentId, Double ammount) {
		
		Optional<Student> op=sr.findById(studentId);
		Student st=op.get();
		st.setFeesPaid(st.getFeesPaid()+ammount);
		sr.save(st);
		
	}
}
