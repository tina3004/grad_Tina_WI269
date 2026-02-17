package com.springstudentrestapi.repositories;

import com.springstudentrestapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    public List<Student> findBySchool(String school);
    public int countBySchool(String school);
    public long countByStandard(int standard);
    public List<Student> findByPercentageGreaterThanEqualOrderByPercentageDesc(double percentage);
    List<Student> findByPercentageLessThanOrderByPercentageDesc(double percentage);

    @Query("select count (s) from Student as s where s.gender=?1 and s.standard=?2")
    public long genderwiseStudents(String gender,int standard);
}
