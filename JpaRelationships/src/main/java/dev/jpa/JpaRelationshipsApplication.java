package dev.jpa;

import dev.jpa.Models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class JpaRelationshipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaRelationshipsApplication.class, args);
    }

}
