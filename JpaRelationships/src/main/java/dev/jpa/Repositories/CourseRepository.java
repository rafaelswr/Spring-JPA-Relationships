package dev.jpa.Repositories;

import dev.jpa.Models.Course;
import dev.jpa.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
