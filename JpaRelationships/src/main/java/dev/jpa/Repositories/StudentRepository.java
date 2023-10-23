package dev.jpa.Repositories;

import dev.jpa.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.studentId = ?1")
    Optional<Student> findStudentById(Long studentId);

}
