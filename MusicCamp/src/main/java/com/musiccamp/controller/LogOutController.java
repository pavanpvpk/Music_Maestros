package com.musiccamp.controller;





import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String logout(ModelMap model,HttpSession session,HttpServletRequest request,
HttpServletResponse response) {
		
		if (request.isRequestedSessionIdValid() && session != null) {
			Cookie[] cookies = request.getCookies();

			for (Cookie cookie : cookies) {

			cookie.setMaxAge(0);

			cookie.setValue(null);

			cookie.setPath("/");

			response.addCookie(cookie);

			}
			session.invalidate();

			}

		return "redirect:/login";
			}
		
	

	}
	
	
    

