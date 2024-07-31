/*
In questa applicazione sarà presente 
una Classe Service che eseguirà delle chiamate
REST verso le operazioni Rest esposte dall'Applicazione Spring
L'applicazione Spring restituirà dei JSON

La Classe Service utilizzerà una API Observable
in grado di mappare i JSON restituitio dal Back End
in Oggetti Typescript creati secondo lo schema di una
Interfaccia

*/

export interface Academy{

    code:string;
    title:string;
    cityLocation:string;
    studentsNumber:number;


}