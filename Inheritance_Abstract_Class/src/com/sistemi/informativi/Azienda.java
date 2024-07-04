package com.sistemi.informativi;


/*
 * La classe astratta, ci sono quando abbiamo delle implementazioni
 * da parte dei figli identiche ed altre invece completamente diverse
 */
public abstract class Azienda {
	public abstract void produce();
	
	public abstract void assume();
	
	public void fattura() 
	{
		System.out.println("fatturo al 22%");
	}
}
