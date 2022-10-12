package com.example.sandbox.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//the class extends JPA
@Repository
public interface studentRepository extends JpaRepository<student, Long> {

    @Query("SELECT s FROM student s WHERE s.email=?1")
    Optional<student> findStudentByEmail(String email);
}
