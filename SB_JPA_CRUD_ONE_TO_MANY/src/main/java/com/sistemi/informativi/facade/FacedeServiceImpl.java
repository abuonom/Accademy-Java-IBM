package com.sistemi.informativi.facade;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;
import com.sistemi.informativi.service.CourseService;
import com.sistemi.informativi.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class FacedeServiceImpl implements FacedeService{

    private final CourseService courseService;
    private final ReviewService reviewService;

    public FacedeServiceImpl(CourseService courseService, ReviewService reviewService) {
        this.courseService = courseService;
        this.reviewService = reviewService;
    }

    @Override
    public void addCourse(Course course) {
        courseService.checkAddCourse(course);
    }

    @Override
    public void removeCourse(int id) {
        courseService.checkRemoveCourse(id);
    }

    @Override
    public void addReview(Review review) {
        reviewService.checkAddReview(review);
    }

    @Override
    public void getReviewsByCourse(int courseId) {
        reviewService.checkReviewsByCourse(courseId);
    }
}
