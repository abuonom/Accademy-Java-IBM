package com.sistemi.informativi;

public class StudenteScolastico extends Studente{
	/*
	 * OVERRIDING significa dichiarare un metodo con la stessa firma del padre
	 * ma con un corpo diverso
	 */
	@Override
	/*
	 * @Override è una annotation di tipo metadato
	 * strumento sintattico fornito da un linguaggio
	 */
	public void studia() 
	{
		System.out.println("Studia da maggio a settembre");
	}
}