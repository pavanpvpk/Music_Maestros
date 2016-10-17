package com.musiccamp.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.musiccamp.entities.Student;
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
	
	@RequestMapping(value="/viewStudentDetails",method=RequestMethod.GET)
	public String viewStudentDetails(ModelMap model, HttpSession session){
		
		List<Student> studentDetails =student.findAll();
		
	     System.out.println("In Student View Controller"+studentDetails.size());
	     
	     for(Student student:studentDetails){
	    	 
	    	 
		     System.out.println("In Student View Controller"+student);

	     }

		 session.setAttribute("details", studentDetails);

		  
		return "viewStudentDetails";
		
	}
	

	

}
