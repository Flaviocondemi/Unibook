package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStudente implements Initializable {
    Unibook unibook = Unibook.getInstance();

    @FXML
    Label matricola;

    @FXML
    TextField orarioinizio,
              orariofine,
              data,
              numpartecipanti,
              materia,
              luogo,
              idesame,
              idricevimento;
    @FXML
    ListView<String> listViewEsami;
    @FXML
    ListView<String> listViewRicevimenti;

    ObservableList<String> listaricevimenti = FXCollections.observableArrayList();
    ObservableList<String> listaesami = FXCollections.observableArrayList();




    @FXML
    public void handleBtnPrenotaEsame() throws IOException {
        MainGui.setRoot("prenota esame");
    }

    @FXML
    public void handleBtnPrenotaRicevimento() throws IOException {
        MainGui.setRoot("prenota ricevimento");
    }

    @FXML
    public void handleBtnBackHome() throws IOException {
        MainGui.setRoot("home studente");
    }

    @FXML
    public void btnPrenotaRicevimento() throws IOException {
        for (Ricevimento ricevimento : unibook.getListaricevimenti()){
            if(idricevimento.getText().equals(String.valueOf(ricevimento.getId()))){
                ricevimento.addStudente(unibook.getStudenteloggato());
                MainGui.setRoot("home studente");
            }
        }
    }

    @FXML
    public void btnPrenotaEsame() throws IOException {
        for(Esame esame : unibook.getListaesami()){
            if (idesame.getText().equals(String.valueOf(esame.getId()))) {
                esame.addStudente(unibook.getStudenteloggato());
                System.out.println(esame.getListaStudentiprenotati());
                MainGui.setRoot("home studente");
            }
        }
    }

    @FXML
    public void btnMostraRicevimenti() throws IOException {
        listaricevimenti.removeAll(listaricevimenti);
        for (Ricevimento ricevimento: unibook.getListaricevimenti()) {
            listaricevimenti.add("id : "+ String.valueOf(ricevimento.getId()));
            System.out.println("aggiunto " +
                    "ricevimento " + ricevimento.toString());
        }
        listViewRicevimenti.getItems().addAll(listaricevimenti);
    }

    @FXML
    public void btnMostraEsami() throws IOException {
        listaesami.removeAll(listaesami);
        for (Esame esame : unibook.getListaesami()){
            listaesami.add("id: "+ String.valueOf(esame.getId()));
            System.out.println("aggiunto " +
                    "esame " + esame.toString());
        }
        listViewEsami.getItems().addAll(listaesami);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(matricola != null) {
            matricola.setText("Matricola: " + unibook.getStudenteloggato().getMatricola());
        }
    }
}
