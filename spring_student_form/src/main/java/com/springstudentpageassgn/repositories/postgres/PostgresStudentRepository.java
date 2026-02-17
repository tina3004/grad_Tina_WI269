package com.springstudentpageassgn.repositories.postgres;

import com.springstudentpageassgn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresStudentRepository extends JpaRepository<Student,Long> {
}
