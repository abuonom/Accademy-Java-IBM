package com.sistemi.informativi.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/*
L'annotation @NamedQuery consente di elencare una lista di query scritte in
linguaggio JPQL
 */

@NamedQueries({
        @NamedQuery(name="Student.getStudent",query = "select s from Student s"),
        @NamedQuery(name="Student.getStudentsByLastName",
                query = "select s from Student s where s.lastName=:lastName")
})

@Entity
public class Student implements Serializable {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI
    private int id;

    @Column(name = "first_namme") //suggerisco ad Hibernate che la column si deve chiamare first_name
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    protected Student() {
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
