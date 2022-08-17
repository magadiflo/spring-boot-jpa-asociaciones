package com.magadiflo.app.controller;

import com.magadiflo.app.entity.Course;
import com.magadiflo.app.entity.Student;
import com.magadiflo.app.service.ICourseService;
import com.magadiflo.app.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/student/course")
public class StudentController {

    private final ICourseService courseService;
    private final IStudentService studentService;

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
        return this.studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    @GetMapping(path = "/{studentId}")
    public Student findStudent(@PathVariable Long studentId) {
        return this.studentService.findStudent(studentId);
    }

    @GetMapping(path = "/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name) {
        return this.studentService.findByNameContaining(name);
    }

    @GetMapping(path = "/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price) {
        return this.courseService.findByFeeLessThan(price);
    }

}
