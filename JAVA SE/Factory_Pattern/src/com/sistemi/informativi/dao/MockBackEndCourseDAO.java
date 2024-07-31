package com.sistemi.informativi.dao;

import com.sistemi.informativi.bean.BackEndCourse;
import com.sistemi.informativi.bean.Course;

import java.util.Objects;
import java.util.stream.Stream;

public interface MockBackEndCourseDAO {
    public Stream<Object> getBackEndCourses();
}
