package com.sistemi.informativi.main;

import com.sistemi.informativi.Operazione;

public class Main {

	public static void main(String[] args) {
		Operazione operazione = new Operazione();
		
		System.out.println("Somma1 " + operazione.somma(7, 6));
		System.out.println("Somma1 " + operazione.somma(7, 6, 9));
	}

}
