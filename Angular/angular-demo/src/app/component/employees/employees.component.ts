import { Component, Input } from '@angular/core';
import { Employee } from '../../model/employee_model';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent {
	@Input() employees : Employee[] = [];
}
