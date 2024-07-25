export class Employee {
	/*
	Se una variabile di istanza TS non è settata all'interno di un costruttore
	si può definire
	1) tramite l'uso del simbolo '!'. Questo simbolo indica che la variabile
	è inizializzata in un secondo momento.
	2) Si può usare il simbolo '?' per indicare che la variabile è opzionale, quindi
	potrebbe essere undefined.
	3) Si può usare il simbolo 'undefined' per indicare che la variabile è undefined
	*/

	firstName: string | undefined;
	lastName!: string;
	age?: number;

	constructor(firstName: string, lastName:string, age?: number){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/*
	In typescript non è possibile fare overloading dei costruttori.
	Perchè abbiamo appunto la possibilità di usare gli optional e gli undefined.
	*/

}
