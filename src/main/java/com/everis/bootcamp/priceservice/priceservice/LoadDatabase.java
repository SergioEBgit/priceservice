package com.everis.bootcamp.priceservice.priceservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PriceService service) {
        return args -> {
            log.info("Preloading " + service.insert(new Price(1, 20)));
            log.info("Preloading " + service.insert(new Price(2,34)));
            log.info("Preloading " + service.insert(new Price(3,77)));
            log.info("Preloading " + service.insert(new Price(4,14)));
        };
    }
}
