package com.cisco.acisizing.acisizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cisco.acisizing.acisizing.configuration.ConfigurationManager;

@SpringBootApplication
public class AciSizingApplication {
	
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AciSizingApplication.class, args);
        ConfigurationManager.getInstance().getConfiguration().setApplicationContext(applicationContext);
    }
}
