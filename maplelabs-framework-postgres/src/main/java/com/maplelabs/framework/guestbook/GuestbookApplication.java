package com.maplelabs.framework.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.maplelabs.framework.guestbook.configuration.ConfigurationManager;

@SpringBootApplication
public class GuestbookApplication {
	
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(GuestbookApplication.class, args);
        ConfigurationManager.getInstance().getConfiguration().setApplicationContext(applicationContext);
    }
}
