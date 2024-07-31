package com.sistemi.informativi.business;

import com.sistemi.informativi.dao.MockBackEndCourseDAO;
import com.sistemi.informativi.dao.MockBackEndCourseDAOImpl;
import com.sistemi.informativi.dao.MockFrontEndCourseDAO;
import com.sistemi.informativi.dao.MockFrontEndCourseDAOImpl;
import com.sistemi.informativi.enumeration.Course;

import java.util.stream.Stream;

public interface Choice {
    public Stream<Object> choice(Course course);
}
