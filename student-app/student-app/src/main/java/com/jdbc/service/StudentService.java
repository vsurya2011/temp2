package com.jdbc.service;

import com.jdbc.dto.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(int regNo);
    Student getStudent(int regNo);
    List<Student> getAllStudents();
}