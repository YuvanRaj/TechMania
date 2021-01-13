package com.techmania.remoteservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.techmania.remoteservice.util.StaticCacheLoader;

@Configuration
@ComponentScan
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class RemoteserviceApplication {
	
	
	private static final Logger logger = LogManager.getLogger(RemoteserviceApplication.class);
	
	public static void main(String[] args) {
		try {
			logger.debug("************RemoteserviceApplication starts*******");
			 SpringApplication application = new SpringApplication(RemoteserviceApplication.class);
			    addInitHooks(application);
			    application.run(args);
			    logger.info("************RemoteserviceApplication ends*******");
			//SpringApplication.run(RemoteserviceApplication.class, args);
		}
		catch(Exception ex) {
			System.out.println("error");
		}
	}

	private static void addInitHooks(SpringApplication application) {
		application.addListeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
		   StaticCacheLoader staticCacheLoader = new StaticCacheLoader();
	       System.out.println("Static Loader Object Initiated");
	       System.out.println("prepareLandingPageDropDowns Cache Initiation Started");
	       staticCacheLoader.prepareLandingPageDropDowns();
	       System.out.println("prepareLandingPageDropDowns Cache Initiation Completed");
	   });
	}

}
