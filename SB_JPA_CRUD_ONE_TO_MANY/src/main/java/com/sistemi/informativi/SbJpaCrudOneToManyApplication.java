package com.sistemi.informativi;

import com.sistemi.informativi.entity.Course;
import com.sistemi.informativi.entity.Review;
import com.sistemi.informativi.facade.FacedeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbJpaCrudOneToManyApplication implements CommandLineRunner {
    private final FacedeService facedeService;

    public SbJpaCrudOneToManyApplication(FacedeService facedeService) {
        this.facedeService = facedeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SbJpaCrudOneToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course = new Course("JAVA SE");
        facedeService.addCourse(course);
        Review review = new Review("Roma");
        Review review2 = new Review("Napoli");
        review.setCourse(course);
        review2.setCourse(course);

        facedeService.addReview(review);
        facedeService.addReview(review2);
        /*
        org.hibernate.LazyInitializationException
        Si verifica questa eccezione, perchè Hibernate effettua la ricerca in
        modalità Lazy.

        Hibernate ha due modi di effettuare le ricerche:

        Lazy = Se facciamo una query sulla tabella Padre, carica nella sua memoria
        solo le informazioni strettamente richieste, senza fare operazioni di lettura
        sulla tabella figlia
        Eager = 
         */
        facedeService.getReviewsByCourse(1);
    }
}
