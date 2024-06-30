package com.sistemi.informativi.business;

import com.sistemi.informativi.dao.MockBackEndCourseDAO;
import com.sistemi.informativi.dao.MockBackEndCourseDAOImpl;
import com.sistemi.informativi.dao.MockFrontEndCourseDAO;
import com.sistemi.informativi.dao.MockFrontEndCourseDAOImpl;
import com.sistemi.informativi.enumeration.Course;
import com.sistemi.informativi.facede.FacedeDAO;
import com.sistemi.informativi.facede.FacedeDAOImpl;

import java.util.stream.Stream;

public class ChoiceImpl implements Choice{

    @Override
    public Stream<Object> choice(Course course) {
        FacedeDAO facedeDAO = new FacedeDAOImpl();
        Stream<Object> courses =
                switch (course)
                {
                    case BACKEND -> facedeDAO.getBackEndCourses();
                    case FRONTEND -> facedeDAO.getFrontEndCourses();
                    default -> throw new IllegalStateException("Unexpected value: " + course);
                };
        return courses;
    }
}
