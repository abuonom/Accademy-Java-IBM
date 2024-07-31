package com.sistemi.informativi.vo;

import java.io.Serializable;

public class StudentVO implements Serializable {

    //mapping autoincrement
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public StudentVO(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
