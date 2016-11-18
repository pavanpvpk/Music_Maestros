package com.musiccamp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.musiccamp.entities.UserLogin;
import com.musiccamp.repositories.UserRepository;

/**
 * 
 * @author Manasa Bojja
 *
 */
@Scope(value = "session")
@Controller
@RequestMapping("/addAdmin")
@SessionAttributes({ "username", "validuser" })
public class AddAdministratorController {

	private static final Logger LOG = LoggerFactory.getLogger(AddAdministratorController.class);

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String checkAccount(@RequestParam("form-username") Integer username, ModelMap model, HttpSession session) {

		UserLogin user = new UserLogin(username, "123456", 0);
		
		UserLogin existingUser = userRepository.findOne(username);
		
		try {
		if(existingUser == null){
			insertUser(user);
			session.setAttribute("error", "Administrator has been added successfully");
			
		}else{
			
			session.setAttribute("error", "Administrator has already been added");
			
		}
		
		
		}catch(Exception e){
			LOG.error( e.getMessage(), e);
			model.addAttribute("invaliduser", "Invalid Credentials");
			session.setAttribute("error", "Invalid Credentials: " + username);
			
			
		}
		return "redirect:/addAdministrators";

	}
	private void insertUser(UserLogin user) {

		userRepository.save(user);
	}


}
