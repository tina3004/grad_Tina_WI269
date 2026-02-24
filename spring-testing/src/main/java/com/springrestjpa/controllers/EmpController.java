package com.springrestjpa.controllers;

import com.springrestjpa.entities.Employee;
import com.springrestjpa.repos.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    private EmpRepo repo;
    @GetMapping("/greet")
    public String hello(){
        return "<h2>Goood Morning";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return repo.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){

        Optional<Employee>emp= repo.findById(id);

        if(emp.isPresent()){
            return ResponseEntity.ok(emp.get());
        }
        else{
            return ResponseEntity.status(204).build();
        }
    }

    @PostMapping("/employees")
    public String getEmployees(@RequestBody Employee e){
        if(repo.existsById(e.getEid())){
            return "Employee already exists";
        }
        repo.save(e);
        return "Employee added";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@RequestBody Employee e, @PathVariable int id) {
        if (e.getEid() != id) {
            return "Emp IDs doesn't match";
        }
        if (!repo.existsById(id))
            return "Sorry ! Employee with given ID doesn't exist";
        repo.save(e);
        return "Successfully updated employee record";

    }

    @DeleteMapping("/employees/{id}")
    public String removeEmployee(@PathVariable int id)
    {
        if(!repo.existsById(id))
            return "No Record available with given ID";
        else
            repo.deleteById(id);
        return "Employee removed successfully.";
    }


    @GetMapping("/employees/role/select")
    public List<Employee> getEmpByDesign(String design){
        return repo.findByDesignation(design);
    }
    @GetMapping("/employees/above/select")
    public List<Employee> seniors(int age)
    {
        return repo.findByAgeGreaterThan(age);
    }
    @GetMapping("/employees/earning/below")
    public List<Employee> earnings(int salary) {
        return repo.findBySalaryLessThan(salary);
    }

    @GetMapping("/employees/custom")
    public List<Employee> customQuery(@RequestParam("role") String design) {
        return repo.myCustomQuery(design);
    }
}
