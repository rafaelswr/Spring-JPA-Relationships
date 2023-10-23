package dev.jpa;

import dev.jpa.Models.*;
import dev.jpa.Repositories.CourseMaterialRepository;
import dev.jpa.Repositories.CourseRepository;
import dev.jpa.Repositories.StudentRepository;
import dev.jpa.Repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

@Configuration
public class AppConfig {

    @Bean
    CommandLineRunner commandLineRunner (CourseRepository courseRepository, CourseMaterialRepository courseMaterialRepository,
                                         TeacherRepository teacherRepository, StudentRepository studentRepository){
        return args -> {
            CourseMaterial ei = new CourseMaterial("https://ipb.pt");
            Course lei = new Course("lei", 180, ei);
            Teacher rufino = new Teacher("Rufino");
            Tutor fer = new Tutor("fer","91301123121");
            Student rafa = new Student("Rafa","rafae@gmail.com",
                    LocalDate.of(1999, Month.JANUARY, 13), fer, lei);


           studentRepository.save(rafa);

        };
    }

}
