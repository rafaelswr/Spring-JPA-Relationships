package dev.jpa.Repositories;

import dev.jpa.Models.Guardian;
import dev.jpa.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Guard;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}
