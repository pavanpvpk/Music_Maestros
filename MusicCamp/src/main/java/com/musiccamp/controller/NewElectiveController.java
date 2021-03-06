package com.musiccamp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musiccamp.entities.Electives;
import com.musiccamp.repositories.ElectiveRepository;



@Controller
public class NewElectiveController {
	
	@Autowired
	private ElectiveRepository ers;
	
	
	@RequestMapping(value="/addElectives",method=RequestMethod.POST )
	public String AddNewElective(@RequestParam("newElective") String newElective, ModelMap model){
		
		
	int newelect=ers.InsertnewElective(newElective);
			if(!(newelect==0)){
				
				model.put("success", "New Elective Added");
				return "successElective";
				
			}
			
			else if(newElective.isEmpty()){
				
				model.put("failure", "something went wrong");
				return "failedelective";
				
			}
			else{
				
				model.put("failure", "something went wrong");
				return "failedelective";
			}
		
	}

}
