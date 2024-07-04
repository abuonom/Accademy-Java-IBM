package com.sistemi.informativi.enumeration;

public enum Pasto {
	Colazione(8,"Sala A"),
	Pranzo(13,"Sala B"),
	Merenda(17,"Sala C"),
	Cena(21,"Sala B");
	
	private int ora;
	private String sala;
	
	
	public int getOra() {
		return ora;
	}

	public String getSala() {
		return sala;
	}
	
	private Pasto(int ora, String sala) {
		this.ora = ora;
		this.sala = sala;
	}


	
	
}