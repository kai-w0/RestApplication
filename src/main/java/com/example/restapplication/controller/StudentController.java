package com.example.restapplication.controller;

import com.example.restapplication.domain.CommonResponse;
import com.example.restapplication.domain.ErrorResponse;
import com.example.restapplication.domain.dto.StudentPostDto;
import com.example.restapplication.exception.ResourceNotFoundException;
import com.example.restapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<CommonResponse> getAllStudents(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<CommonResponse> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<CommonResponse> createStudent(@RequestBody StudentPostDto studentPostDto) {
        return new ResponseEntity<>(studentService.createStudent(studentPostDto), HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<CommonResponse> updateStudent(@RequestBody StudentPostDto postDto, @PathVariable String id) {
        return new ResponseEntity<>(studentService.updateStudent(postDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<CommonResponse> deleteStudent(@PathVariable String id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundHandler() {
        return new ResponseEntity<>(new ErrorResponse("this is the message", new Date()), HttpStatus.NOT_FOUND);
    }
}
