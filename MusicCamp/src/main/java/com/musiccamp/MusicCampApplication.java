package com.musiccamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.musiccamp.services.StorageProperties;
import com.musiccamp.services.StorageService;

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
@ComponentScan({"com.musiccamp.controller"})//Scans this package for all the Spring Controllers
@PropertySource("classpath:application.properties") // Reads database properties and other stuff from application.properties
//@EnableConfigurationProperties(StorageProperties.class)
public class MusicCampApplication  {
	public static void main(String[] args) {
		SpringApplication.run(MusicCampApplication.class, args);
	
}
	
//	@Bean
//	CommandLineRunner init(StorageService storageService) {
//		return (args) -> {
//            storageService.deleteAll();
//            storageService.init();
//		};
//	}
}
