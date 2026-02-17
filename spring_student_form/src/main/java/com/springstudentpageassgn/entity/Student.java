package com.springstudentpageassgn.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    private String rollno;
    private String name;
    private String standard;
    private String school;


    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
