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
}
