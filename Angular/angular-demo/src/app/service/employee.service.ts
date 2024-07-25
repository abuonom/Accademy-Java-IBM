import { Injectable } from '@angular/core';
import { Employee } from '../model/employee_model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
	employee1 : Employee = new Employee("Mario","Rossi",22);
	employee2 : Employee = new Employee("Giulio","Verdi",27);
	employees = [this.employee1,this.employee2];

	constructor() { }

	getEmployees(): Employee[]{
		return this.employees;
	}
}
