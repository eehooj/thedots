package com.example.tictoccroc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TictoccrocApplication {

    public static void main(String[] args) {
        SpringApplication.run(TictoccrocApplication.class, args);
    }

}
