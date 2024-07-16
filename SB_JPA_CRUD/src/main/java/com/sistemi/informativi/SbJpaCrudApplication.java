package com.sistemi.informativi;

import com.sistemi.informativi.entity.Student;
import com.sistemi.informativi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
La classe annotata con @SpringBootApplication rappresenta l'application Context
 */
@SpringBootApplication
public class SbJpaCrudApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(SbJpaCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.checkAddStudent(new Student("Paolo","Rossi",23));
        studentService.checkAddStudent(new Student("Mario","Rossi",23));
        studentService.checkAddStudent(new Student("Giuseppe","Verdini",25));
        studentService.checkAddStudent(new Student("Gioele","Verdini",23));
        studentService.checkUpdateStudent(new Student(3,"Gioele","Verdini",24));
        studentService.checkRemoveStudent(1);
        studentService.checkGetStudents();
        studentService.checkGetStudentsByLastName("Verdini");

    }
}
