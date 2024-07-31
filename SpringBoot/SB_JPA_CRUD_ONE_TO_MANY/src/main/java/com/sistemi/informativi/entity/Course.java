package com.sistemi.informativi.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    String title;

    //RELAZIONE HAS-A
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course",cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<Review>();

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    protected Course() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Course(String title) {
        this.title = title;
    }
}
