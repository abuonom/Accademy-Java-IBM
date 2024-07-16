package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepositoryImpl extends JpaRepository<Employee,String> {

    /*
    Estendendo JpaRepository ereditiamo metodi esposti da questa interfaccia che
    contengono già logiche di CRUD, tipo

    save -> Inserimento, aggiornamento
    findAll -> Lettura integrale
    findById -> ricerca per PL
    deleteById -> cancellazione per PK
     */


    /*
    La parola chiave find, viene tradotta in SELECT FROM EMPLOYEE
    la parola BY viene tradotta in WHERE
     */
    public List<Employee> findByLastName(String lastName);

    //SELECT e FROM EMPLOYEE E WHERE e.experienceYear > experienceYear
    public List<Employee> findByExperienceYearsGreaterThan(int experienceYear);
}
