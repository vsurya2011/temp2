package com.jdbc.operation;

import com.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteOperation implements Operation {

    @Autowired
    private StudentService service;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("RegNo: ");
        service.deleteStudent(sc.nextInt());
    }
}