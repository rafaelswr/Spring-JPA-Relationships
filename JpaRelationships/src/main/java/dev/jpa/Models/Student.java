package dev.jpa.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long studentID;
    private String name;
    private String email;
    private LocalDate birth;

    @Transient
    private int age;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseID",referencedColumnName = "courseID")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="guardianID", referencedColumnName = "guardianID")
    private Guardian guardian;

    public int getAge(){
        return Period.between(birth, LocalDate.now()).getYears();
    }

    public Student(String name, String email, LocalDate birth, Guardian guardian, Course course) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.guardian = guardian;
        this.course = course;
    }
}
