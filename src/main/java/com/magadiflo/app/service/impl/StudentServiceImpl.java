package com.magadiflo.app.service.impl;

import com.magadiflo.app.entity.Student;
import com.magadiflo.app.repository.IStudentRepository;
import com.magadiflo.app.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findByNameContaining(String name) {
        return this.studentRepository.findByNameContaining(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }
}
