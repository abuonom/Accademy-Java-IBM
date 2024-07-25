import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './service/employee.service';
import { Employee } from './model/employee_model';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  employees : Employee[] = [];
  /*
  INIZIALIZZAZIONE DI UN ARRAY DI EMPLOYEE VUOTO
  QUESTO ARRAY SAR° VALORIZZATO AL'INTERNO DEL METODO
  ON INIT TRAMITE INVOCAZIONE DEL METODO getEmployees
  del Service
  /


  /
  CONSTRUCTOR INJECTION

  Si passa in input al costruttore della Component
  un parametro con livello di visibilità private del
  tipo del Service che deve essere istanziato

  Node.JS applicherà il pattern IoC:
  private employeeService : EmployeeService = new EmployeeService();




  /
  Il metodo ngOnInit viene invocato
  sempre al caricamento nel Component
  */

  constructor(private employeeService : EmployeeService){

  }
  ngOnInit(): void {

    this.employees = this.employeeService.getEmployees();
  }

  handleName(value:string){
	console.log(value);
  }




}
