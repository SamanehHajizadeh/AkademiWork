
package com.springboot.codeChallenge;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
class LoadDatabase {
    private final static Logger log = Logger.getLogger(LoadDatabase.class.getName());

   @Bean
    CommandLineRunner initDatabase(NumberRepository numberRepository) {
        PerfectNumber number = new PerfectNumber(6,6,28);

        return args -> {
            PerfectNumber andFlush = numberRepository.saveAndFlush(number);
            log.info("Preloading " + andFlush);
        };
    }
}
