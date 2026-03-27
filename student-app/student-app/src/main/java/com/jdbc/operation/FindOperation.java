package com.jdbc.operation;

import com.jdbc.dto.Student;
import com.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindOperation implements Operation {

    @Autowired
    private StudentService service;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("RegNo: ");
        Student s = service.getStudent(sc.nextInt());
        System.out.println(s);
    }
}