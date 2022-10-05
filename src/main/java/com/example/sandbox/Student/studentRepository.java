package com.example.sandbox.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//the class extends JPA
@Repository
public interface studentRepository extends JpaRepository<student, Long> {
}
