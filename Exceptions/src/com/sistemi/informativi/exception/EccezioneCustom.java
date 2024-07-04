package com.sistemi.informativi.exception;

public class EccezioneCustom extends Exception{
	/*
	 * Stiamo creando un eccezione custom, e nel costruttore invochiamo il
	 * costruttore della classe padre, dandogli il messaggio che associamo
	 * all'eccezione, per far stampare un messaggio di errore meno generico
	 * del solito
	 */
	public EccezioneCustom(String message) {
		super(message);
	}
	
	
}
