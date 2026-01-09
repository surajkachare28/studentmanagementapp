package edu.cjc.sma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sma.app.model.Student;
import edu.cjc.sma.app.serviei.StudentServicei;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@Autowired
	StudentServicei ss;
	
	@RequestMapping("/")
	public String preLogin()
	{
		return "login";
	}
	@RequestMapping("/login")
	public String onLogin(@RequestParam("username") String username,@RequestParam("password") String password, Model m )
	{
		if(username.equals("admin") && password.equals("admin"))
		{
		List<Student> student=ss.getAllStudents();
				m.addAttribute("data",student);
				
				return "adminscreen";
		}else {
			m.addAttribute("login_fail","enter valid login details");
			
			return "login";
			
		}
		}
		@RequestMapping("enroll_student")
		public String saveStudent(@ModelAttribute Student stu,Model m)
		{
			ss.saveStudentDetails(stu);
			
				List<Student> student=ss.getAllStudents();
				m.addAttribute("data",student);
		
			return "adminscreen";
	}
		@RequestMapping("/search")
		public String getBatchStudent(@RequestParam String batchNumber,@RequestParam String batchMode,Model m)
		{
		List<Student> result=ss.searchStudentsByBatch(batchNumber,batchMode);
			if(result.size()>0)	
			{
				m.addAttribute("data",result);
			}else {
				
				List<Student> student=ss.getAllStudents();
				m.addAttribute("data",student);
			m.addAttribute("message", "No record are availabel for the batch " +batchNumber+ "...!");
			}
			return "adminscreen";
	}
		@RequestMapping("/delete")
		public String deleteById(@RequestParam int studentId, Model m) {

	    ss.deleteStudentById(studentId);
		    
		    List<Student> student = ss.getAllStudents();
		    m.addAttribute("data", student);

		    return "adminscreen";
		}
		@RequestMapping("/fees")
		public String onFees(@RequestParam int studentId,Model m)
		{			
			Student st = ss.getSingleStudent(studentId);
			m.addAttribute("st",st);
			return "fees";
		}

		
		@RequestMapping("/payfees")
		public String payFees(@RequestParam("studentid") int studentId,@RequestParam Double ammount,Model m) 
		{
			ss.updateStudentFees(studentId,ammount);
			List<Student> student = ss.getAllStudents();
		    m.addAttribute("data", student);
			
			return "adminscreen";
		}

}




