package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.repository.CourseRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService,ErrorService{
    Logger log = LoggerFactory.getLogger(this.getClass());

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void checkAddCourse(Course course) {
        try {
            courseRepository.addCourse(course);
            log.info(addSuccessMessage);
        } catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException ex) {

            log.info(addErrorMessage);
            ex.printStackTrace();
        }
    }

    @Override
    public void checkRemoveCourse(int id) {
        try {
            courseRepository.removeCourse(id);
            log.info(deleteSuccessMessage);
        } catch (IllegalArgumentException | TransactionRequiredException ex) {
            log.info(deleteErrorMessage);
            ex.printStackTrace();
        }
    }
}
