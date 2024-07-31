package com.sistemi.informativi.main;

import java.util.ArrayList;
import java.util.TreeMap;

import com.sistemi.informativi.enumeration.Pasto;
import com.sistemi.informativi.enumeration.Settimana;

public class Main {

	public static void main(String[] args) {
		ArrayList <Settimana> giorni = new ArrayList<>();
		for(Settimana iterator : Settimana.values()) {
			giorni.add(iterator);
		}
		
		System.out.println(giorni);
		
		TreeMap<Integer, String> pasti = new TreeMap<>();
		
		for (Pasto iterator : Pasto.values()) {
			pasti.put(iterator.getOra(), iterator.getSala());
		}
		System.out.println(pasti);
	}

}