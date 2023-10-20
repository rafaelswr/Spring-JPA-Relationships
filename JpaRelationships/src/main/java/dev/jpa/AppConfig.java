package dev.jpa;

import dev.jpa.Models.*;
import dev.jpa.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import static java.time.Month.DECEMBER;


@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner commandLineRunner (CourseMaterialRepository courseMaterialRepository, CourseRepository courseRepository, TeacherRepository teacherRepository, StudentRepository studentRepository, GuardianRepository guardianRepository){
        return args -> {

        };
    }

}
