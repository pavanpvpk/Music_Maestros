package com.musiccamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author Pavan Kumar Pedda Vakkalam
 *
 *Main class that invokes the whole Spring Boot application. 
 *This class allows us to run this web application as a simple java app. 
 *Spring boot has an embedded Tomcat Container in it.
 */


@EnableWebMvc
@EnableAutoConfiguration
@Configuration
@ComponentScan("com.musiccamp.controller") //Scans this package for all the Spring Controllers
@PropertySource("classpath:application.properties") // Reads database properties and other stuff from application.properties
public class MusicCampApplication  {
	public static void main(String[] args) {
		SpringApplication.run(MusicCampApplication.class, args);
		
		
	}
}
