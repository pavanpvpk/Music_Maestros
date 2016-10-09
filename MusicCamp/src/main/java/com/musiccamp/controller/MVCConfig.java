
package com.musiccamp.controller;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 **/
@Configuration
public class MVCConfig extends WebMvcAutoConfigurationAdapter {

	//Creates view names and maps with the html file names
	UserController uc;
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/login").setViewName("login");
	registry.addViewController("/adminhome").setViewName("adminhome");
	registry.addViewController("/userhome").setViewName("userhome");
	registry.addViewController("/viewStudentDetails").setViewName("viewStudentDetails");
	registry.addViewController("/uploadStudentDetails").setViewName("uploadStudentDetails");
	registry.addViewController("/viewMasterSchedule").setViewName("viewMasterSchedule");
	registry.addViewController("/editMasterSchedule").setViewName("editMasterSchedule");
	}
	
	
	
}
