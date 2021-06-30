package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.lab04.model.*;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model modello;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> boxCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField idMatricola;

    @FXML
    private Button btnGreen;

    @FXML
    private TextField idNome;

    @FXML
    private TextField idCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Button btnReset;

    @FXML
    void cercaCorsi(ActionEvent event) {
    	Corso corso = this.boxCorsi.getSelectionModel().getSelectedItem();
    	String matricola = this.idMatricola.getText();
    	if(corso == null) {
        	if(matricola == null) {
        		this.txtOutput.setText("Errore: non è presente questa matricola");
        	}
        	else {
        		String res = this.modello.cercaCorsi(matricola);
        		this.txtOutput.setText(res);
        	}
    	}
    	else {
    		boolean trovato = this.modello.isStudenteIscritto(matricola, corso);
    		if(trovato) {
    			this.txtOutput.setText("Studente già iscritto al corso");
    		}
    		else this.txtOutput.setText("Studente non ancora iscritto al corso");
    	}

    }

    @FXML
    void cercaIscrittiCorso(ActionEvent event) {
    	Corso corso = this.boxCorsi.getSelectionModel().getSelectedItem();
    	if(corso==null) {
    		this.txtOutput.setText("Errore: nessun corso selezionato");
    	}
    	else {
    	String res = this.modello.getIscrittiCorso(corso);
    	this.txtOutput.setText(res);
    	}
    }

    @FXML
    void completamentoAutomatico(ActionEvent event) {
    	
    	String matr = this.idMatricola.getText();
    	String nome = this.modello.getNomeMatr(matr);
    	String cognome = this.modello.getCognomeMatr(matr);
    	this.idNome.setText(nome);
    	this.idCognome.setText(cognome);

    }

    @FXML
    void iscrivi(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {
    	this.txtOutput.clear();
    	this.boxCorsi.getSelectionModel().clearSelection();
    	this.idCognome.clear();
    	this.idNome.clear();
    	this.idMatricola.clear();
    }

    @FXML
    void initialize() {
        assert boxCorsi != null : "fx:id=\"boxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert idMatricola != null : "fx:id=\"idMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnGreen != null : "fx:id=\"btnGreen\" was not injected: check your FXML file 'Scene.fxml'.";
        assert idNome != null : "fx:id=\"idNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert idCognome != null : "fx:id=\"idCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }

	public void setModel(Model m) {
		this.modello = m;
		this.boxCorsi.getItems().addAll(this.modello.getCorsi());
	}
	
}
