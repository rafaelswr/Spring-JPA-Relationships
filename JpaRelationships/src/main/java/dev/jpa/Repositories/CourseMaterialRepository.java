package dev.jpa.Repositories;

import dev.jpa.Models.CourseMaterial;
import dev.jpa.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
