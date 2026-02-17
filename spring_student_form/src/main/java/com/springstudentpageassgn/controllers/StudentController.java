package com.springstudentpageassgn.controllers;

import com.springstudentpageassgn.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.springstudentpageassgn.entity.Student;
@Controller
public class StudentController {

    @Autowired
    private StudentService service;
//    @GetMapping("/")
//    public ModelAndView showForm(){
//        return new ModelAndView("student-form");
//    }
    @GetMapping("/")
    public String showForm() {
        return "redirect:/student-form.html";
    }

    @PostMapping("/save")
    public ModelAndView saveStudent(String rollno, String name, String standard, String school ){
        Student s=new Student();
        s.setRollno(rollno);
        s.setName(name);
        s.setStandard(standard);
        s.setSchool(school);

        service.insertStudent(s);
        return new ModelAndView("redirect:/");
    }
}
