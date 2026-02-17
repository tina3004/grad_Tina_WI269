package com.springstudentrestapi.controllers;

import com.springstudentrestapi.entities.Student;
import com.springstudentrestapi.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepo repo;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return repo.findAll();
    }

    @GetMapping("/students/{regNo}")
    public Optional<Student> getStudentbyRegNo(@PathVariable int regNo){
        return repo.findById(regNo);
    }

    @PostMapping("/students")
    public String insertStudents(@RequestBody Student s){
        if(repo.existsById(s.getRegNo())){
            return "Student with this regNo already exists";
        }
        repo.save(s);
        return "Student added ";
    }
    @PutMapping("/students/{regNo}")
    public String updateStudent(@RequestBody Student s, @PathVariable int regNo){
        if(s.getRegNo()!=regNo){
            return "Student reg nos do not match";
        }
        if(!repo.existsById(s.getRegNo())){
            return "Student does not exist";
        }
        repo.save(s);
        return "Student updated";
    }

    @DeleteMapping("/students/{regNo}")
    public String removeStudent(@PathVariable int regNo)
    {
        if(!repo.existsById(regNo))
            return "No Record available with given ID";
        else
            repo.deleteById(regNo);
        return "Employee removed successfully.";
    }

    @PatchMapping("/students/{regNo}")
    public String updateStudentUsingPatch(@RequestBody Student s, @PathVariable int regNo){
        Optional<Student>currStudent=repo.findById(regNo);

        if(currStudent.isEmpty()){
            return "Student not found";
        }
        Student updatedStudent= currStudent.get();

        if(s.getRollNo()!=0){
            updatedStudent.setRollNo(s.getRollNo());
        }
        if(s.getName()!=null){
            updatedStudent.setName(s.getName());
        }
        if(s.getStandard()!=0){
            updatedStudent.setStandard(s.getStandard());
        }
        if(s.getSchool()!=null){
            updatedStudent.setSchool(s.getSchool());
        }
        if(s.getGender()!=null){
            updatedStudent.setGender(s.getGender());
        }
        if(s.getPercentage()!=0){
            updatedStudent.setPercentage(s.getPercentage());
        }
        repo.save(updatedStudent);
        return "Student updated partially";
    }

    @GetMapping("/students/school")
    public List<Student> findStudentBySchoolName(@RequestParam("name") String school){
        return repo.findBySchool(school);
    }

    @GetMapping("/students/school/count")
    public int schoolStrength(@RequestParam("name") String school){
        return repo.countBySchool(school);
    }

    @GetMapping("/students/school/standard/count")
    public long numOfStudents(@RequestParam("class") int standard){
        return repo.countByStandard(standard);
    }

    @GetMapping("/students/result")
    public List<Student> getResults(@RequestParam boolean pass){
        if(pass){
            return repo.findByPercentageGreaterThanEqualOrderByPercentageDesc(40.0);
        }
        else{
            return repo.findByPercentageLessThanOrderByPercentageDesc(40.0);
        }
    }
    @GetMapping("/students/strength")
    public long strength(String gender, int standard){
        return repo.genderwiseStudents(gender,standard);
    }
}
