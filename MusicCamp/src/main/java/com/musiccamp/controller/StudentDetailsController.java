
package com.musiccamp.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musiccamp.entities.Student;
import com.musiccamp.repositories.ElectiveRepository;
import com.musiccamp.repositories.StudentRepository;

/**
 * 
 * @author Manasa Bojja
 *
 **/
@Controller
public class StudentDetailsController {
	
	private static final Logger LOG=LoggerFactory.getLogger(StudentDetailsController.class);

	
	@Autowired
	private StudentRepository student;
	
	@Autowired
	private ElectiveRepository electiveids;
	
	// To display list of students
	@RequestMapping(value="/viewStudentDetails",method=RequestMethod.GET)
	public String viewStudentDetails(ModelMap model, HttpSession session){
		
		List<Student> studentDetails =student.findAll();

		 session.setAttribute("details", studentDetails);

		  
		return "viewStudentDetails";
		
	}
	
	//To display information of a particular student
	@RequestMapping(value="/studentData",method=RequestMethod.GET)
	public String studentData(HttpSession session,
			@RequestParam(value="id", required = true) Integer argName){
	   // System.out.println("***********"+argName);
		
	    Student studentInfo =  student.find(argName);
	    session.setAttribute("student", studentInfo);
		return "studentData";
		
	}
	
	
}
