package com.sistemi.informativi.facede;

import com.sistemi.informativi.dao.MockBackEndCourseDAO;
import com.sistemi.informativi.dao.MockBackEndCourseDAOImpl;
import com.sistemi.informativi.dao.MockFrontEndCourseDAO;
import com.sistemi.informativi.dao.MockFrontEndCourseDAOImpl;

import java.util.stream.Stream;

public class FacedeDAOImpl implements FacedeDAO {
    MockBackEndCourseDAO beDAO = new MockBackEndCourseDAOImpl();
    MockFrontEndCourseDAO feDAO = new MockFrontEndCourseDAOImpl();
    @Override
    public Stream<Object> getFrontEndCourses() {
        return feDAO.getFrontEndCourses();
    }

    @Override
    public Stream<Object> getBackEndCourses() {
        return beDAO.getBackEndCourses();

    }
}
