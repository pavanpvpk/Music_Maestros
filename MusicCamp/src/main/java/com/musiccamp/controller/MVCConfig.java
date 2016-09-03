package com.musiccamp.controller;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class MVCConfig extends WebMvcAutoConfigurationAdapter {

	//Creates a view names and maps with the html
	UserController uc;
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/login").setViewName("login");
	registry.addViewController("/adminhome").setViewName("adminhome");
	registry.addViewController("/userhome").setViewName("userhome");	
		
	}
	
	
	
}
