package com.sistemi.informativi.main;

import com.sistemi.informativi.business.Contatore;

public class Main {

	public static void main(String[] args) {
		Contatore contatore1 = new Contatore();
		Contatore contatore2 = new Contatore();
		contatore1.conta();
		contatore2.conta();
	}

}