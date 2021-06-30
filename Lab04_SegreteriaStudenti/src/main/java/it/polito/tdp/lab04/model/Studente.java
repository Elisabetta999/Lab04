package it.polito.tdp.lab04.model;

public class Studente {
	String nome;
	String cognome;
	String matricola;
	String corsoDiStudi;
	public Studente(String nome, String cognome, String matricola, String corsoDiStudi) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.corsoDiStudi = corsoDiStudi;
	}
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
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getCorsoDiStudi() {
		return corsoDiStudi;
	}
	public void setCorsoDiStudi(String corsoDiStudi) {
		this.corsoDiStudi = corsoDiStudi;
	}
	

}
