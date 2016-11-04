package com.musiccamp.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope(value="session")
public class StudentScheduleController {

	
	@RequestMapping("/schedulegen")
	
	public String Schedulegen(ModelMap model,@RequestParam("studentName") String studentName){
		
		
		System.out.println(studentName);
		
		return "gensuccess";
	}
}
