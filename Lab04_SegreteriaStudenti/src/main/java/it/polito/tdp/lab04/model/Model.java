package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO crDao;
	StudenteDAO stDao;
	
	public Model() {
		crDao = new CorsoDAO();
		stDao = new StudenteDAO();
	}
	
	public List<Corso> getCorsi(){
		return this.crDao.getTuttiICorsi();
	}

	public String getNomeMatr(String matr) {
		String nome = stDao.getNomeMatr(matr);
		return nome;
	}

	public String getCognomeMatr(String matr) {
		String cognome = stDao.getCognomeMatr(matr);
		return cognome;
	}

}
