package com.sistemi.informativi.handler;

import com.sistemi.informativi.exception.EccezioneCustom;

public class GestioneEccezioneCustom {
	
	public void riceviEta(int eta) throws EccezioneCustom {
		if(eta>18)
			System.out.println();
		else
			throw new EccezioneCustom("Età inferiore al limite consentito");
	}
}