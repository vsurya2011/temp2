package com.jdbc.repository.impl;

import com.jdbc.dto.Student;
import com.jdbc.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public void delete(int regNo) {
        Student s = em.find(Student.class, regNo);
        if (s != null) em.remove(s);
    }

    @Override
    public Student findById(int regNo) {
        return em.find(Student.class, regNo);
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("FROM Student", Student.class).getResultList();
    }
}