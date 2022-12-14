package com.magadiflo.app.service;

import com.magadiflo.app.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findByNameContaining(String name);

    List<Student> findAllStudents();

    Student findStudent(Long id);

    Student saveStudent(Student student);

}
