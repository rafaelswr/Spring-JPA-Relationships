package dev.jpa.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long teacherID;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_course",
        joinColumns = @JoinColumn(name = "teacherID", referencedColumnName = "teacherID"),
        inverseJoinColumns = @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    )
    private List<Course> courses = new ArrayList<>();

    public Teacher(String name) {
        this.name = name;
    }
}
