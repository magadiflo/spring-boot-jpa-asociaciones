package com.magadiflo.app.repository;

import com.magadiflo.app.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(double fee);

}
