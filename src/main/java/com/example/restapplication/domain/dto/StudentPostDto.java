package com.example.restapplication.domain.dto;

import com.example.restapplication.domain.Student;

public class StudentPostDto {

    private String id;
    private String name;
    private boolean active;

//    public StudentPostDto(Student student) {
//        this.id = student.getId();
//        this.name = student.getName();
//        this.active = student.isActive();
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
