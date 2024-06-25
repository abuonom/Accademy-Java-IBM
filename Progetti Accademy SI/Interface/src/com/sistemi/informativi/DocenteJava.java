package com.sistemi.informativi;

public class DocenteJava implements Docente{
	@Override
	public void spiegaLinguaggio() 
	{
		System.out.println("spiega Java");
	}

	@Override
	public void spiegaFramework() {
		System.out.println("spiega Angular");
	}

	@Override
	public void spiegaArchitettura() {
		System.out.println("spiega oracle");
	}
	
	public void faPausa() {
		System.out.println("facciamo pausa");
	}
}
