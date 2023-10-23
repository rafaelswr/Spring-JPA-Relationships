package dev.jpa.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Data
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutorId", referencedColumnName = "tutorId")
    public Tutor tutor;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public Student(String name, String email, LocalDate dob, Tutor tutor, Course course) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.course = course;
        this.tutor = tutor;
    }
}
