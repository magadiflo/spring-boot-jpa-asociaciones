package com.magadiflo.app.repository;

import com.magadiflo.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);

}
