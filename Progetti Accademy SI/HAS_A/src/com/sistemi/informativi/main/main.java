package com.sistemi.informativi.main;

import com.sistemi.informativi.bean.Indirizzo;
import com.sistemi.informativi.bean.Persona;

public class main {

	public static void main(String[] args) {
		Persona persona = new Persona("Alessio", "Buonomo", 25, new Indirizzo("Corso Garibaldi", "70", "80055", "Portici"));
		System.out.println(persona);
	}

}