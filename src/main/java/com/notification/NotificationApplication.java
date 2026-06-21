package com.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class NotificationApplication {

    private final static Logger log = LoggerFactory.getLogger(NotificationApplication.class);
    


    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        SpringApplication.run(NotificationApplication.class, args);
        log.info("Application Started");
    }
}