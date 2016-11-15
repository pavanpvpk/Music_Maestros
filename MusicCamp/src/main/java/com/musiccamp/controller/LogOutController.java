package com.musiccamp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope(value="session")
public class LogOutController {

	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(ModelMap model,HttpSession session){
		
		session =null;
		return "redirect:/login";

	}
}
