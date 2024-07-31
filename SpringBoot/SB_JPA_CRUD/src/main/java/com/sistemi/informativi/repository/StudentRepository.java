package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Student;

import java.util.List;

//Non annotiamo Repository, perchè basta la classe che implementa
public interface StudentRepository {

    public void addStudent(Student student);
    public Student getStudent(int id);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
    public List<Student> getAllStudents();
    public List<Student> getStudentsByLastName(String lastName);
}
