package com.sistemi.informativi;

public class main {
	public static void main(String[] args) 
	{
		/*
		 * Ogni oggetto ha un ciclo di vita (nasce, vive, muore)
		 * Questo ciclo avviene dentro l'HEAP
		 * Nasce quando viene costruito
		 * p1 è una reference all'Oggetto Person
		 * Una reference rappresenta un controllo remoto su un Oggetto
		 * 
		*/
		Person p1 = new Person();
		Person p2 = new Person();
		/*
		 * Vita di un oggetto = modifica dell'Oggetto
		 */
		p1.firstName= "Mario";
		p1.lastName= "Rossi";
		p1.age = 21;
		
		
		p2.firstName= "Mario";
		p2.lastName= "Rossi";
		p2.age = 21;
		//HashCode è un identificativo assegnato all'oggetto, se viene fatto
		//ovveride di hashcode e equals, gli hashcode di oggetti con stesso contenuto
		//saranno uguali
		System.out.println("OGGETTO 1 " + p1.hashCode());
		System.out.println("OGGETTO 2 " + p2.hashCode());
		System.out.println(p1.firstName + " " + p1.lastName + " " + p1.age);
		
		p1=p2;

		System.out.println(p1.firstName + " " + p1.lastName + " " + p1.age);
		System.out.println(p1==p2);
		
		p1 = null;
		System.gc(); //BAD PRACTIES non si utilizza invocare il garbage collector durante esecuzione
		
	}
}
