package com.example.restapplication.service;

import com.example.restapplication.domain.CommonResponse;
import com.example.restapplication.domain.dto.StudentPostDto;

public interface StudentService {

    CommonResponse getAllStudents();
    CommonResponse getStudentById(String id);

    CommonResponse createStudent(StudentPostDto studentPostDto);

    CommonResponse updateStudent(StudentPostDto studentPostDto, String id);

    CommonResponse deleteStudent(String id);
}
