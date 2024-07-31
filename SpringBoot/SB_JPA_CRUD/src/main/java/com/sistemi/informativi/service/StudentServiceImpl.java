package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Student;
import com.sistemi.informativi.repository.StudentRepository;
import com.sistemi.informativi.repository.StudentRepositoryImpl;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.TransactionRequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    Logger log = LoggerFactory.getLogger(this.getClass());
    /*
    L'annotation @AutoWired rappresenta uno dei 3 modi forniti da spring per
    la Dependecny Injection.
    Dietro le quinte l'IoC Container eseguirà le seguenti azioni:
    StudentRepository studentRepository = new StudentRepositoryImpl();
     */


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void checkAddStudent(Student student) {
        try {
            studentRepository.addStudent(student);
            log.info("Operazione Inserimento Corretta");
        } catch (IllegalArgumentException | EntityExistsException |TransactionRequiredException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkUpdateStudent(Student student) {
        try {
            studentRepository.updateStudent(student);
            log.info("Operazione Update Corretta");
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkRemoveStudent(int id) {
        try {
            studentRepository.deleteStudent(id);
            log.info("Operazione Delete Corretta");
        }
        catch (IllegalArgumentException | TransactionRequiredException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkGetStudents() {
        List<Student> students = studentRepository.getAllStudents();
        if(!students.isEmpty()) {
            students.forEach(student -> log.info(student.toString()));
        }else {
            log.info("Operazione GET non riuscita");
            System.out.println("Operazione GET non riuscita");
        }
        }

    @Override
    public void checkGetStudentsByLastName(String lastName) {
        List<Student> students = studentRepository.getStudentsByLastName(lastName);
        if(!students.isEmpty()) {
            students.forEach(student -> log.info(student.toString()));
        }else {
            log.info("Operazione GET non riuscita");
            System.out.println("Operazione GET non riuscita");
        }
    }
}
