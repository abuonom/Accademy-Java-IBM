package com.sistemi.informativi.dao;

import com.sistemi.informativi.bean.BackEndCourse;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class MockBackEndCourseDAOImpl implements MockBackEndCourseDAO{

    @Override
    public Stream<Object> getBackEndCourses() {
        ArrayList<String> languages1 = new ArrayList<>();
        languages1.add("Java");
        languages1.add("JPQL");

        ArrayList<String> frameworks1 = new ArrayList<>();
        frameworks1.add("Spring MVC");
        frameworks1.add("Spring Restful");

        ArrayList<String> languages2 = new ArrayList<>();
        languages2.add("C#");
        languages2.add("BOH");

        ArrayList<String> frameworks2 = new ArrayList<>();
        frameworks2.add("Frame1");
        frameworks2.add("Frame2");

        BackEndCourse course1 =
                new BackEndCourse("Java Spring", "Rome",frameworks1,languages1,"mySQL");
        BackEndCourse course2 =
                new BackEndCourse(".Net", "Milano",frameworks2,languages2,"mySQL");

        return Stream.of(course1,course2);
    }
}
