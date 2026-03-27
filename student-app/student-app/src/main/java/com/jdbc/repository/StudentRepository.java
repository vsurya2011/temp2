package com.jdbc.repository;

import com.jdbc.dto.Student;
import java.util.List;

public interface StudentRepository {
    void save(Student student);
    void delete(int regNo);
    Student findById(int regNo);
    List<Student> findAll();
}