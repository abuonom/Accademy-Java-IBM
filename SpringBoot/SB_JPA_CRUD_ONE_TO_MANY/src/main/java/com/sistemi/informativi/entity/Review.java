package com.sistemi.informativi.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String location;

    //Relazione HAS-A
    /*
    Hibernate crea nella tabella Review una FK dandogli di default il nome:
    nomeentity_nomevariabile PK ex course_id
     */
    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    protected Review() {

    }

    public Review(String location) {
        this.location = location;
    }

}
