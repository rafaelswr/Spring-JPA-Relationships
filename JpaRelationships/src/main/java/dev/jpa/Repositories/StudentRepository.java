package dev.jpa.Repositories;

import dev.jpa.Models.Student;
import dev.jpa.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
