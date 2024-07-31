package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Review;
import com.sistemi.informativi.repository.ReviewRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService, ErrorService {

    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void checkAddReview(Review review) {
        try {
            reviewRepository.addReview(review);
            log.info(addSuccessMessage);
        } catch (IllegalArgumentException | EntityExistsException | TransactionRequiredException ex) {

            log.info(addErrorMessage);
            ex.printStackTrace();
        }
    }

    @Override
    public void checkReviewsByCourse(int courseId) {
        try{
            reviewRepository.getReviewsByCourse(courseId).
                    forEach(review -> log.info(review.toString()));
        }catch (NullPointerException ex){
            log.info(getErrorMessage);
            ex.printStackTrace();
        }
    }
}
