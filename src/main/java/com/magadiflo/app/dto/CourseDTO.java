package com.magadiflo.app.dto;

import com.magadiflo.app.entity.Course;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseDTO {

    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.abbreviation = course.getAbbreviation();
        this.modules = course.getModules();
        this.fee = course.getFee();
    }

}
