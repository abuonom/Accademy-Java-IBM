package com.sistemi.informativi.bean;

public class Indirizzo {
	private String via;
	private String nCivico;
	private String cap;
	private String città;

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getnCivico() {
		return nCivico;
	}

	public void setnCivico(String nCivico) {
		this.nCivico = nCivico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
	}

	public Indirizzo(String via, String nCivico, String cap, String città) {
		this.via = via;
		this.nCivico = nCivico;
		this.cap = cap;
		this.città = città;
	}

	@Override
	public String toString() {
		return "Indirizzo [via=" + via + ", nCivico=" + nCivico + ", cap=" + cap + ", città=" + città + "]";
	}

}
