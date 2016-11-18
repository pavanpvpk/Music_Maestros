
package com.musiccamp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musiccamp.entities.Electives;
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
	private StudentRepository studentRT;
	
	@Autowired
	private ElectiveRepository electiveRT;
	
	// To display list of students
	@RequestMapping(value="/viewStudentDetails",method=RequestMethod.GET)
	public String viewStudentDetails(ModelMap model, HttpSession session){
		
		if(!(session.getAttribute("validuser")==null)){
			
			List<Student> studentDetails =studentRT.findAll();

			 session.setAttribute("details", studentDetails);

			  
			return "viewStudentDetails";
			
		}
		else{
			
			return "login";
		}

		
		
	}
	

	//To display information of a particular student
	@RequestMapping(value="/studentData",method=RequestMethod.GET)
	public String studentData(HttpSession session,
			@RequestParam(value="id", required = true) Integer argName){
	   // System.out.println("***********"+argName);
		
		if(!(session.getAttribute("validuser")==null)){
			
	    Student studentInfo =  studentRT.find(argName);
	    List<Electives> electives = electiveRT.findAll();
	    session.setAttribute("student", studentInfo);
	    session.setAttribute("electives", electives);
		return "studentData";
		
	}
		else{
			return "login";
		}
	
	}
	
	@RequestMapping(value="/generateSchedule",method=RequestMethod.GET)
	public String generateSchedule(HttpSession session,
			@RequestParam(value="sid", required = true) Integer studentId,
			@RequestParam(value="name") String name,
			@RequestParam(value="grade") String grade,
			@RequestParam(value="track") String track,
			@RequestParam(value="priInstrument") String priInstrument,
			@RequestParam(value="secInstrument") String secInstrument,
			@RequestParam(value="elec1") String elec1,
			@RequestParam(value="elec2") String elec2,
			@RequestParam(value="elec3") String elec3,
			@RequestParam(value="elec4") String elec4,
			Model model){
	    System.out.println("***********"+name);
	    
	    Student student = studentRT.find(studentId);
	    student.setStatus("Scheduled");
	    studentRT.save(student);
	    //StudentSchedule studentSchedule = new StudentSchedule(student, electiveId1, electiveId2, electiveId3, electiveId4);
	   // studentSchRT.save(studentSchedule);
	    LOG.info("Student Scheduled details saved sucessfully "+studentId);
	    
		
//	    Student studentInfo =  student.find(argName);
//	    session.setAttribute("student", studentInfo);
	    
		return "redirect: /viewStudentDetails";
		
	}
}
