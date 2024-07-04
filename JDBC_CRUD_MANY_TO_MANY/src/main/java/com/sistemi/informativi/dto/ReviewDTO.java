package com.sistemi.informativi.dto;

import java.io.Serializable;

public class ReviewDTO implements Serializable {

    private String location;
    private int courseID;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public ReviewDTO(String location, int courseID) {
        this.location = location;
        this.courseID = courseID;
    }
}
