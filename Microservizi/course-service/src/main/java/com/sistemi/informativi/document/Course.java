package com.sistemi.informativi.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "course")
public class Course {
    @MongoId
    private String code;
    private String title;
    private List<Review> reviews;
    private List<Teacher> teachers;
    private List<Student> students;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    protected Course(){

    }

    public Course(List<Student> students, List<Teacher> teachers, List<Review> reviews, String title, String code) {
        this.students = students;
        this.teachers = teachers;
        this.reviews = reviews;
        this.title = title;
        this.code = code;
    }
}
