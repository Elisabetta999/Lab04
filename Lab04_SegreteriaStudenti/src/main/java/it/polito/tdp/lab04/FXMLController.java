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

    }

    @FXML
    void cercaIscrittoCorso(ActionEvent event) {

    }

    @FXML
    void completamentoAutomatico(ActionEvent event) {

    }

    @FXML
    void iscrivi(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

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
		System.out.println(this.modello.getCorsi());
		this.boxCorsi.getItems().addAll(this.modello.getCorsi());
	}
	
}
