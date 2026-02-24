package com.springrestjpa.repos;

import com.springrestjpa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findByDesignation(String desig);
    public List<Employee> findByAgeGreaterThan(int age);
    public List<Employee> findBySalaryLessThan(int salary);

    @Query("from Employee where designation=?1 order by salary DESC")
    public List<Employee> myCustomQuery(String design);
}
