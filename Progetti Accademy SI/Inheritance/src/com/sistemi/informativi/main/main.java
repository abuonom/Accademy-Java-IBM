package com.sistemi.informativi.main;

import com.sistemi.informativi.Persona;
import com.sistemi.informativi.Studente;
import com.sistemi.informativi.StudenteScolastico;
import com.sistemi.informativi.StudenteUniversitario;

public class main {

	public static void main(String[] args) {
		Persona persona = new Persona();
		
		persona.cammina();
		persona.dorme();
		persona.mangia();
		System.out.println();
		Studente studente = new Studente();
		studente.cammina();
		studente.dorme();
		studente.mangia();
		studente.studia();
		System.out.println();
		StudenteScolastico studenteScolastico = new StudenteScolastico();
		studenteScolastico.cammina();
		studenteScolastico.dorme();
		studenteScolastico.mangia();
		studenteScolastico.studia();
		System.out.println();
		StudenteUniversitario studenteUniversitario = new StudenteUniversitario();
		studenteUniversitario.cammina();
		studenteUniversitario.dorme();
		studenteUniversitario.mangia();
		studenteUniversitario.studia();
		System.out.println();
	}

}
