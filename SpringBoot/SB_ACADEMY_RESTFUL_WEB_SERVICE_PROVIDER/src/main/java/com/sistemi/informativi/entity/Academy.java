package com.sistemi.informativi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Collate;

import java.io.Serializable;

@Entity
public class Academy implements Serializable {

    @Id
    //Diciamo ad Hibernate che il campo deve avere dimensione max 4
    @Column(length = 4)
    //Size blocca qualsiasi JSON che ha un code diverso da size 4
    @Size(min=4,max = 4)
    private String code;

    @Column(length = 50,nullable = false)
    private String title;
    @Column(name = "city_location",length = 50)
    private String cityLocation;
    @Column(name = "student_number")
    private int studentNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
