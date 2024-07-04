package com.sistemi.informativi.bean;

public class Persona {
	private String nome;
	private String cognome;
	private int età;
	private Indirizzo indirizzo; // relazione HAS-A

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEtà() {
		return età;
	}

	public void setEtà(int età) {
		this.età = età;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Persona(String nome, String cognome, int età, Indirizzo indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.età = età;
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", età=" + età + ", indirizzo=" + indirizzo + "]";
	}

}
