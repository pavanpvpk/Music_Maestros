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

import com.musiccamp.entities.Student;
import com.musiccamp.entities.UserLogin;
import com.musiccamp.repositories.StudentRepository;
import com.musiccamp.repositories.UserRepository;

/**
 * 
 * @author Manasa Bojja
 *
 */
@Scope(value = "session")
@Controller
@RequestMapping("/validateRegister")
@SessionAttributes({ "username", "validuser" })
public class ValidateRegisterController {

	private static final Logger LOG = LoggerFactory.getLogger(ValidateRegisterController.class);

	@Autowired
	private StudentRepository student;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String checkAccount(@RequestParam("form-username") Integer username,
			@RequestParam("form-password") String password,
			@RequestParam("form-confirmpassword") String confirmpassword, ModelMap model, HttpSession session) {
		String redirectView = "";

		try {

			Student stud = student.findOne(username);
			UserLogin existingUser = userRepository.findOne(username);
			if (password.equals(confirmpassword)) {
				if (username.equals(stud.getStudentId()) && existingUser==null) {
					System.out.println("success");
					UserLogin user = new UserLogin(username, password, 1);
					insertUser(user);
					redirectView = "redirect:/login";
				}else if(username.equals(stud.getStudentId()) && existingUser!=null){
					session.setAttribute("error", "You have already registered");
					redirectView = "redirect:/login";
					
				}
				
			} else {

				session.setAttribute("error", "Passwords doesn't match");
				redirectView = "redirect:/register";

			}

		} catch (Exception e) {
			LOG.error(username + " Doesn't Exist in DB " + e.getMessage(), e);
			model.addAttribute("invaliduser", "Invalid Credentials");
			session.setAttribute("error", "Invalid Credentials: " + username);
			// session.setAttribute("username", username);
			redirectView = "redirect:/register";

		}
		return redirectView;

	}

	private void insertUser(UserLogin user) {

		userRepository.save(user);
	}

}
