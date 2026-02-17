package com.springstudentpageassgn.repositories.h2;

import com.springstudentpageassgn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2StudentRepository extends JpaRepository<Student,Long> {

}
