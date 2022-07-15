package com.example.restapplication.service.impl;

import com.example.restapplication.domain.CommonResponse;
import com.example.restapplication.domain.Student;
import com.example.restapplication.domain.dto.StudentPostDto;
import com.example.restapplication.domain.dto.StudentResponseDTO;
import com.example.restapplication.exception.ResourceNotFoundException;
import com.example.restapplication.repository.StudentRepository;
import com.example.restapplication.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public CommonResponse getAllStudents() {
        CommonResponse response = new CommonResponse();
        List<StudentResponseDTO> studentResponseDTOS = studentRepository.getAllStudents().stream().map(s -> new StudentResponseDTO(s)).collect(Collectors.toList());
        response.setData(studentResponseDTOS);
        return response;
    }

    @Override
    public CommonResponse getStudentById(String id) {

        CommonResponse response = new CommonResponse();
        Student stu = studentRepository.getStudentById(id);
        if(stu == null) {
            log.error("{} id cannot be found in system", id);
            throw new ResourceNotFoundException("........");
        }
        response.setData(new StudentResponseDTO(stu));
        return response;
    }

    @Override
    public CommonResponse createStudent(StudentPostDto studentPostDto) {
        CommonResponse response = new CommonResponse();
        studentRepository.createStudent(studentPostDto);
        response.setData("created successfully");
        return response;
    }

    @Override
    public CommonResponse updateStudent(StudentPostDto postDto, String id) {
        CommonResponse response = new CommonResponse();
        Student student = studentRepository.updateStudent(id, postDto);
        response.setData(new StudentPostDto(student));
        return response;
    }

    @Override
    public CommonResponse deleteStudent(String id) {
        CommonResponse response = new CommonResponse();
        studentRepository.deleteStudent(id);
        response.setData("deleted successfully");
        return response;
    }
}
