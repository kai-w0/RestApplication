package com.example.restapplication.repository.impl;

import com.example.restapplication.domain.Student;
import com.example.restapplication.domain.dto.StudentPostDto;
import com.example.restapplication.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Map<String, Student> studentMap = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        Student s1 = new Student("1", "Tom", true);
        Student s2 = new Student("2", "Jerry", true);
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    @Override
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    @Override
    public void createStudent(StudentPostDto postDto) {
        Student s = new Student();
        s.setId("" + studentMap.size()+1);
        s.setName(postDto.getName());
        s.setActive(postDto.isActive());
        studentMap.put(s.getId(), s);
    }

    @Override
    public Student updateStudent(String id, StudentPostDto postDto) {
        Student s = studentMap.get(id);
        s.setName(postDto.getName());
        s.setActive(postDto.isActive());
        studentMap.put(id, s);
        return studentMap.get(id);
    }

    @Override
    public void deleteStudent(String id) {
        studentMap.remove(id);
    }
}
