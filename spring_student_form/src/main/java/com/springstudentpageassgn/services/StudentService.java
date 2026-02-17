package com.springstudentpageassgn.services;

import com.springstudentpageassgn.entity.Student;
import com.springstudentpageassgn.repositories.h2.H2StudentRepository;
import com.springstudentpageassgn.repositories.postgres.PostgresStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private PostgresStudentRepository pgrepo;
    @Autowired
    private H2StudentRepository h2repo;
    public void insertStudent(Student s){
        pgrepo.save(s);
        h2repo.save(s);

    }
}
