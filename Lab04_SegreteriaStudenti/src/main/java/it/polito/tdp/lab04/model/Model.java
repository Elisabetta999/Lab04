package it.polito.tdp.lab04.model;

import java.util.LinkedList;
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

	public String getIscrittiCorso(Corso corso) {
		List<Studente> studenti = this.crDao.getStudentiIscrittiAlCorso(corso);
		String s = "";
		for(Studente st:studenti) {
			s=s+st.getMatricola()+" "+st.getNome()+" "+st.getCognome()+" "+st.getCorsoDiStudi()+"\n";
		}
		return s;
	}

	public String cercaCorsi(String matricola) {
		List<Corso> corsiIscritto = this.stDao.getCorsiIscritto(matricola);
		String s = "";
		for(Corso cr:corsiIscritto) {
			s=s+cr.getCodins()+" "+cr.getCrediti()+" "+cr.getNome()+" "+cr.getPd()+"\n";
		}
		return s;		
	}

	public boolean isStudenteIscritto(String matricola, Corso corso) {
		return this.stDao.isIscritto(matricola, corso);
	}

}
