package com.jdbc.dto;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sno")
    private int sno;

    @Column(name = "regno", unique = true, nullable = false)
    private int regNo;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private Date dob;

// getters & setters

    public int getRegNo() {
        return regNo;
    }

    public int getSno() {
        return sno;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getDob() {
        return dob;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", regNo=" + regNo +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}