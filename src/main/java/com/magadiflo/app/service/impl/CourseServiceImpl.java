package com.magadiflo.app.service.impl;

import com.magadiflo.app.entity.Course;
import com.magadiflo.app.repository.ICourseRepository;
import com.magadiflo.app.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findByFeeLessThan(double fee) {
        return this.courseRepository.findByFeeLessThan(fee);
    }

}
