package com.example.restapplication.repository;

import com.example.restapplication.domain.Student;
import com.example.restapplication.domain.dto.StudentPostDto;

import java.util.Collection;

public interface StudentRepository {
    Collection<Student> getAllStudents();
    Student getStudentById(String id);
    void createStudent(StudentPostDto postDto);
    Student updateStudent(String id, StudentPostDto postDto);
    void deleteStudent(String id);

}
