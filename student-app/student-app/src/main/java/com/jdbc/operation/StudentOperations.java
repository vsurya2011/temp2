package com.jdbc.operation;

import com.jdbc.dto.Gender;
import com.jdbc.dto.Student;
import com.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class StudentOperations {

    @Autowired
    private StudentService service;

    private Scanner sc = new Scanner(System.in);

    public void insertStudent() {
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Gender (MALE/FEMALE): ");
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
        System.out.println("✅ Inserted Successfully");
    }

    public void findStudent() {
        System.out.print("Enter RegNo: ");
        int regNo = sc.nextInt();

        Student s = service.getStudent(regNo);

        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("❌ Not Found");
        }
    }

    public void findAllStudents() {
        List<Student> list = service.getAllStudents();

        if (list.isEmpty()) {
            System.out.println("No records found");
            return;
        }

        list.forEach(System.out::println);
    }

    public void deleteStudent() {
        System.out.print("Enter RegNo: ");
        int regNo = sc.nextInt();

        service.deleteStudent(regNo);
        System.out.println("🗑 Deleted Successfully");
    }
}