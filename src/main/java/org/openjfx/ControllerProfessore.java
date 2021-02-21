package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerProfessore implements Initializable {

    Unibook unibook = Unibook.getInstance();

    @FXML
    Label matricola;

    @FXML
    TextField orarioinizio,
            orariofine,
            data,
            numpartecipanti,
            titolo,
            modalità,
            luogo,
            nomemateria,
            cfu;


    @FXML
    public void handleBtnCreaEsame() throws IOException {
        MainGui.setRoot("crea esame");
    }

    @FXML
    public void handleBtnCreaRicevimento() throws IOException {
        MainGui.setRoot("crea ricevimento");
    }

    @FXML
    public void handleBtnInserisciMateria() throws IOException {
        MainGui.setRoot("inserisci materia");
    }

    @FXML
    public void handleBtnBackHome() throws IOException {
        MainGui.setRoot("home professore");
    }

    @FXML
    public void btnCreaEsame() throws IOException{
        Esame esame = new Esame();
        esame.setData(data.getText());
        esame.setNomemateria(nomemateria.getText());
        esame.setIdprofessore(unibook.getProfessoreloggato().getMatricola());
        esame.setNumerpartecipanti(Integer.parseInt(numpartecipanti.getText()));
        esame.setLuogo(luogo.getText());
        esame.setOrariofine(orarioinizio.getText());
        esame.setOrariofine(orariofine.getText());
        unibook.creaEsame(esame);

        for (Esame esame1 : unibook.getListaesami()){
            System.out.println(esame1.toString());
        }
        MainGui.setRoot("home professore");

    }

    @FXML
    public void btnCreaRicevimento() throws IOException{
        Ricevimento ricevimento = new Ricevimento();
        ricevimento.setTitolo(titolo.getText());
        ricevimento.setData(data.getText());
        ricevimento.setIdprofessore(unibook.getProfessoreloggato().getMatricola());
        ricevimento.setNumerpartecipanti(Integer.parseInt(numpartecipanti.getText()));
        ricevimento.setLuogo(luogo.getText());
        ricevimento.setOrariofine(orarioinizio.getText());
        ricevimento.setOrariofine(orariofine.getText());
        unibook.creaRicevimento(ricevimento);

        for(Ricevimento ricevimento1 : unibook.getListaricevimenti()) {
            System.out.println(ricevimento1.toString());
        }
        MainGui.setRoot("home professore");

    }

    @FXML
    public void btnInserisciEsame() throws IOException{
        Materia materia = new Materia();
        materia.setNome(nomemateria.getText());
        materia.setCfu(Integer.parseInt(cfu.getText()));
        unibook.getProfessoreloggato().inserisciMateria(materia);
        for (Materia materia1 : unibook.getProfessoreloggato().getListamaterie()) {
            System.out.println(materia1.toString());
        }
        MainGui.setRoot("home professore");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(matricola != null) {
            matricola.setText("Matricola: " + unibook.getProfessoreloggato().getMatricola());
        }
    }
}
