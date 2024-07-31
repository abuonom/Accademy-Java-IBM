package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Employee;
import com.sistemi.informativi.repository.EmployeeRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${add.update.success.message}")
    private String addUpdateSuccessMessage;

    @Value("${add.update.error.message}")
    private String addUpdateErrorMessage;

    @Value("${delete.success.message}")
    private String deleteSuccessMessage;

    @Value("${delete.error.message}")
    private String deleteErrorMessage;

    @Value("${get.error.message}")
    private String getErrorMessage;


    EmployeeRepositoryImpl employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            log.info(addUpdateSuccessMessage);
        } catch (Exception e) {
            log.info(addUpdateErrorMessage);
        }
    }

    @Override
    public void deleteEmployee(String passportNumber) {
        try {
            employeeRepository.deleteById(passportNumber);
            log.info(deleteSuccessMessage);
        } catch (Exception e) {
            log.info(deleteErrorMessage);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try {
            employeeRepository.delete(employee);
            log.info(deleteSuccessMessage);
        } catch (Exception e) {
            log.info(deleteErrorMessage);
        }
    }

    @Override
    public void getEmployeeByLastName(String lastName) {
        try {
            employeeRepository.findByLastName(lastName);
            log.info(deleteSuccessMessage);
        } catch (Exception e) {
            log.info(deleteErrorMessage);
        }

    }

    @Override
    public void getAllEmployees() {
        try {
            employeeRepository.findAll();
            log.info(deleteSuccessMessage);
        } catch (Exception e) {
            log.info(deleteErrorMessage);
        }
    }

    @Override
    public void getEmployeesByExperienceYearsGreaterThan(int experienceYears) {
        try {
            employeeRepository.findByExperienceYearsGreaterThan(experienceYears).forEach(employee -> log.info(employee.toString()));
            log.info(deleteSuccessMessage);
        } catch (Exception e) {
            log.info(deleteErrorMessage);
        }
    }

    @Override
    public Employee getEmployeeByPassportNumber(String passportNumber) {
        return employeeRepository.findById(passportNumber)
                .orElseThrow(() -> new EntityNotFoundException(getErrorMessage));
    }
}
