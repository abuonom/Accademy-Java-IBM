package com.sistemi.informativi.Main;

import com.sistemi.informativi.business.Operazione;
import com.sistemi.informativi.exception.EccezioneCustom;
import com.sistemi.informativi.handler.GestioneEccezioneCustom;

public class Main {

	public static void main(String[] args) throws EccezioneCustom {
		/*
		 * Operazione operazione = new Operazione();
		try {
			operazione.divisione(7,0);			
		}catch(Exception E) {
			System.out.println("Esco con eccezione" + E);
			E.printStackTrace();
		}
		 */
		
		GestioneEccezioneCustom gestione = new GestioneEccezioneCustom();
		gestione.riceviEta(17);
	}

}