package com.magadiflo.app.service;

import com.magadiflo.app.entity.Course;

import java.util.List;

public interface ICourseService {

    List<Course> findByFeeLessThan(double fee);

}
