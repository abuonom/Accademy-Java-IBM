package com.sistemi.informativi.document;

public class Teacher {
    private String firstName;
    private String lastName;
    private int experienceYears;
    public Teacher(String firstName, String lastName, int experienceYears) {
        this.firstName = firstName;
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
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}
