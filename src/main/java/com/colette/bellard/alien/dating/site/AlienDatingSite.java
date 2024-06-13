package com.colette.bellard.alien.dating.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AlienDatingSite is the main class of the application.
 * It is annotated with @SpringBootApplication because it is a Spring Boot application.
 */
@SpringBootApplication
public class AlienDatingSite {

    /**
     * The main method is the entry point of the application.
     * It uses SpringApplication.run to launch the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AlienDatingSite.class, args);
    }

}