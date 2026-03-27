package com.jdbc.service.impl;

import com.jdbc.dto.Student;
import com.jdbc.repository.StudentRepository;
import com.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void deleteStudent(int regNo) {
        repository.delete(regNo);
    }

    @Override
    public Student getStudent(int regNo) {
        return repository.findById(regNo);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}