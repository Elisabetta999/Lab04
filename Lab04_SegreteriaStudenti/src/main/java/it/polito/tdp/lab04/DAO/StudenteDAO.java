package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public String getNomeMatr(String matr) {
		final String sql = "select nome from studente where matricola=?";
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, matr);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			//System.out.println(rs.getString("nome"));
			return rs.getString("nome");}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getCognomeMatr(String matr) {
		final String sql = "select cognome from studente where matricola=?";
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, matr);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			return rs.getString("cognome");}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Corso> getCorsiIscritto(String matricola) {
		final String sql = "SELECT * FROM iscrizione, corso WHERE iscrizione.codins=corso.codins AND iscrizione.matricola=?";

		List<Corso> corsiIscritto = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				String codins = rs.getString("codins");
				int crediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int pd = rs.getInt("pd");

				Corso c = new Corso(codins, crediti, nome, pd);
				corsiIscritto.add(c);
			}

			conn.close();
			
			return corsiIscritto;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

	public boolean isIscritto(String matricola, Corso corso) {
		final String sql = "SELECT * FROM iscrizione WHERE codins=? AND matricola=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			st.setString(2, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				return true;
			}

			conn.close();
			
			return false;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}

	}

}
