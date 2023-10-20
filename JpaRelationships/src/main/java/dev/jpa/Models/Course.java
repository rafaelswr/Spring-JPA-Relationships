package dev.jpa.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long courseID;
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseMaterialID", referencedColumnName = "courseMaterialID")
    private CourseMaterial courseMaterial;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Teacher> teachers = new ArrayList<>();

    public Course(String name, CourseMaterial courseMaterial){
        this.name = name;
        this.courseMaterial = courseMaterial;
    }

}
