package com.musiccamp.controller;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.musiccamp.repositories.UserRepository;
import com.musiccamp.entities.UserLogin;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 */

//@Scope("session")
@Controller
@RequestMapping("/home")
public class UserController {

	private static final Logger LOG=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository use;
//	
//	@Autowired
//	private RoomTimingsRepository rtr;
//	
//	@Autowired
//	private RoomRepository rrp;
//	
//	@Autowired
//	private TimingRepository tr;
	
@RequestMapping(method=RequestMethod.POST)
    public String checkAccount(@RequestParam("form-username") 
    Integer username,@RequestParam("form-password") String password, ModelMap model,
    HttpSession session) {
	
		try{
			
//	List<RoomTimings> rtg=rtr.findAll();
//	List<Room> rl=rrp.findAll();
//	
//	List<Timings> time= tr.findAll();
//	
//	model.put("alltimes", time);
//	model.put("allrooms", rl);
//	model.put("rtk", rtg);	
		
			// Indirect from of select query
			UserLogin users =use.findOne(username);
						
			if(username.equals(users.getUsername()) && 
						password.equals(users.getPassword())){
				
				
				if (users.getRole()==0){
					LOG.info(username+" logged in successfully as admin");
					return "/adminhome";
				
					
				}
				else if( users.getRole()==1){
					LOG.info(username+" logged in successfully as user");
					model.addAttribute("username",username);
					return "/userhome";
				}
				
				
				else{
					LOG.info("username "+username+" and password "+password.toString()+ " mismatch");
					model.addAttribute("invaliduser","Invalid Credentials");
					session.setAttribute("error", "Invalid Credentials: "+username);
					return "redirect:/login";
				}	
				
				
			}
			
			else{
				LOG.info("username "+username+" and password "+password.toString()+ " mismatch");
				model.addAttribute("invaliduser","Invalid Credentials");
				session.setAttribute("error", "Invalid Credentials: "+username);
				return "redirect:/login";
			}	
				
		}
			catch(Exception e){
				
				LOG.error(username +" Doesn't Exist in DB " +e.getMessage(),e);
				model.addAttribute("invaliduser","Invalid Credentials");
				session.setAttribute("error", "Invalid Credentials: "+username);
				//session.setAttribute("username", username);
				return "redirect:/login";
			}

		
		}
		
			
		}
		

	

