package com.jdbc.operation;

import com.jdbc.dto.Gender;
import com.jdbc.dto.Student;
import com.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Scanner;

@Component
public class InsertOperation implements Operation {

    @Autowired
    private StudentService service;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Gender: ");
        Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());

        System.out.print("RegNo: ");
        int regNo = sc.nextInt();

        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("DOB (yyyy-mm-dd): ");
        Date dob = Date.valueOf(sc.nextLine());

        Student s = new Student();
        s.setName(name);
        s.setGender(gender);
        s.setRegNo(regNo);
        s.setEmail(email);
        s.setDob(dob);

        service.addStudent(s);
    }
}