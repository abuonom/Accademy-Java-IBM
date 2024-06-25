package com.sistemi.informativi;

public class Operazione {
	
	/*
	 *  In Java l'Overloading  significa dichiarare all'interno della
	 *  stessa classe più di un metodo con stesso nome, ma firme che differiscono
	 *  nel tipo, o nel numero dei parametri in input.
	 *  Non possiamo cambiare solo il tipo di ritorno.
	 * 
	 */
	public int somma(int x, int y) 
	{
		return (x + y);
	}
	
	public int somma(int x, int y, int z) 
	{
		return (x + y + z);
	}
	
	
	public float somma(float x, float y) 
	{
		return (x + y);
	}
}
