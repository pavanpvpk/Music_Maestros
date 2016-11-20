
package com.musiccamp.controller;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 
 * @author Pavan Kumar Pedda Vakkalam and Manasa Bojja
 *
 **/
@Configuration
@EnableWebMvc
public class MVCConfig extends WebMvcAutoConfigurationAdapter {

	//Creates view names and maps with the html file names
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/login").setViewName("login");
	registry.addViewController("/adminhome").setViewName("adminhome");
	registry.addViewController("/userhome").setViewName("userhome");
	registry.addViewController("/viewStudentDetails").setViewName("viewStudentDetails");
	registry.addViewController("/uploadStudentDetails").setViewName("uploadStudentDetails");
	registry.addViewController("/viewMasterSchedule").setViewName("viewMasterSchedule");
	registry.addViewController("/editMasterSchedule").setViewName("editMasterSchedule");
	registry.addViewController("/studentSchedule").setViewName("studentSchedule");
	registry.addViewController("/aboutUs").setViewName("aboutUs");
	registry.addViewController("/contact").setViewName("contact");
	registry.addViewController("/faq").setViewName("faq");
	registry.addViewController("/schedulegen").setViewName("gensuccess");
	registry.addViewController("/register").setViewName("register");
	registry.addViewController("/addAdministrators").setViewName("addAdministrators");
	registry.addViewController("/addElective").setViewName("/addElectives");
	super.addViewControllers( registry );

	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		// TODO Auto-generated method stub
//		registry.addResourceHandler("/*");
//		super.addResourceHandlers(registry);
//	}
	
}
