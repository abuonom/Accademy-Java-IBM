package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Employee;

public interface EmployeeService {

    public void saveOrUpdateEmployee(Employee employee);
    public void deleteEmployee(String passportNumber);
    public void deleteEmployee(Employee employee);
    public void getEmployeeByLastName(String lastName);
    public void getAllEmployees();
    public void getEmployeesByExperienceYearsGreaterThan(int experienceYears);
    public Employee getEmployeeByPassportNumber(String passportNumber);
}
