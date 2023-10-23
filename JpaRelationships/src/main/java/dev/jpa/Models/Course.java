package dev.jpa.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NoArgsConstructor
@Data
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;

    private String name;
    private int credit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cmId", referencedColumnName = "cmId")
    private CourseMaterial courseMaterial;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_teacher",
            joinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
    )
    private List<Teacher> teachers = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();
    public Course(String name, int credit, CourseMaterial courseMaterial) {
        this.name = name;
        this.credit = credit;
        this.courseMaterial = courseMaterial;
    }
}
