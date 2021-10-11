/**************************************************************************************************************************** /
//
// Class Name : BlogapplicationApplication
// File/Class/Function Description: This is the main application startup class
//
// Revision History
//               	 Date:           			  Changed By    	            Revision Comments
//                   10/10/2021 (DD-MM-YYYY)      Sidheshwar                    Initial writing of code.
//					
//
/****************************************************************************************************************************/
package com.blog.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.blog.application")
public class BlogapplicationApplication {

	private static final Logger logger = LoggerFactory.getLogger(BlogapplicationApplication.class);

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("SpringApplicationBuilder call");
		return application.sources(BlogapplicationApplication.class);

	}

	public static void main(String[] args) {
		/*******************************************************************************************************************
		 * / Start the application for Development
		 ********************************************************************************************************************/
		logger.info("main method call");
		SpringApplication.run(BlogapplicationApplication.class, args);
	}

}
