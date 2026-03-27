package com.jdbc.operation;

import com.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllOperation implements Operation {

    @Autowired
    private StudentService service;

    @Override
    public void execute() {
        service.getAllStudents().forEach(System.out::println);
    }
}