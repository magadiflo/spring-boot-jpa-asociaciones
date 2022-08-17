package com.magadiflo.app.controller;

import com.magadiflo.app.dto.StudentDTO;
import com.magadiflo.app.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/student/course")
public class StudentController {
    private final IStudentService studentService;

    @GetMapping
    public List<StudentDTO> findAllStudents() {
        return this.studentService.findAllStudents().stream()
                .map(StudentDTO::new).collect(Collectors.toList());
    }

}
