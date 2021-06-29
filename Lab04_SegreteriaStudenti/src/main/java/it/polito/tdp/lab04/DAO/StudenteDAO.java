package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
