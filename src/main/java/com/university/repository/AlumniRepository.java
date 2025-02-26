package com.university.repository;

import com.university.model.Alumni;
import com.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:query% OR s.email LIKE %:query% OR s.graduationYear LIKE %:query%")
    List<Student> search(@Param("query") String query);
}
