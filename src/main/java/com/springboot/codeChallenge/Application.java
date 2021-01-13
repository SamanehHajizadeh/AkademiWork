
package com.springboot.codeChallenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NumberRepository repository;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    //@Override
    public void run(String... args) throws Exception {
        //Code to run at application startup
    }
}
