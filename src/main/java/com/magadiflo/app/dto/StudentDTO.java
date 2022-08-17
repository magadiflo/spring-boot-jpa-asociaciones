package com.magadiflo.app.dto;

import com.magadiflo.app.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class StudentDTO {

    private Long id;
    private String name;
    private int age;
    private String dept;
    private Set<CourseDTO> courses = new HashSet<>();

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.dept = student.getDept();

        student.getCourses().forEach(course -> {
            CourseDTO courseDto = new CourseDTO(course);
            this.courses.add(courseDto);
        });
    }
}
