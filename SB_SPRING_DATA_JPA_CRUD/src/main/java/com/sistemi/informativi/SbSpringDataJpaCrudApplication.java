package com.sistemi.informativi;

import com.sistemi.informativi.entity.Employee;
import com.sistemi.informativi.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbSpringDataJpaCrudApplication implements CommandLineRunner {

    EmployeeService employeeService;

    public SbSpringDataJpaCrudApplication(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SbSpringDataJpaCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee("1028A","Mario","Rossi",21);
        Employee employee2 = new Employee("1028B","Giulio","Rossi",15);
        Employee employee3 = new Employee("1028C","Teresa","Proto",10);
        Employee employee4 = new Employee("1028D","Giuseppe","Lollis",12);
        Employee employee5 = new Employee("1028E","Marco","Liberati",13);

        // INSERIMENTI
        employeeService.saveOrUpdateEmployee(employee1);
        employeeService.saveOrUpdateEmployee(employee2);
        employeeService.saveOrUpdateEmployee(employee3);
        employeeService.saveOrUpdateEmployee(employee4);
        employeeService.saveOrUpdateEmployee(employee5);

        // AGGIORNAMENTO
        Employee employeeToUpdate = new Employee("1028E","Marco","Liberati",14);
        employeeService.saveOrUpdateEmployee(employeeToUpdate);

        // CANCELLAZIONE CON OGGETTO
        employeeService.deleteEmployee(employee3);

        // CANCELLAZIONE CON PK
        employeeService.deleteEmployee("1028D");

        // READ ALL EMPLOYEES
        employeeService.getAllEmployees();

        // READ ALL EMPLOYEES CON LASTNAME ROSSI
        employeeService.getEmployeeByLastName("Rossi");

        // READ ALL EMPLOYEES CON EXPERIENCEYEARS > 14
        employeeService.getEmployeesByExperienceYearsGreaterThan(14);

        System.out.println(employeeService.getEmployeeByPassportNumber("1028A").toString());
    }
}
