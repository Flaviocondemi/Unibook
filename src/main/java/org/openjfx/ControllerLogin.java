package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    Unibook unibook = Unibook.getInstance();

    @FXML
    TextField nome,
              cognome,
              mail,
              matricola,
              birth,
              idUni,
              password,
              corsostudio;

    @FXML
    TextField matricolaLoginStudente,
              matricolaloginProfessore,
              passwordLoginStudente,
              passwordLoginProfessore;

    @FXML
    Label errorLabel;


    //Methods--------------------------
    @FXML
    public void handleBtnRegistraProfessore() throws IOException {
        MainGui.setRoot("registra professore");

    }
    @FXML
    public void handleBtnLoginProfessore() throws IOException {
        MainGui.setRoot("login professore");

    }
    @FXML
    public void handleBtnRegistraStudente() throws IOException {
        MainGui.setRoot("registra studente");

    }
    @FXML
    public void handleBtnLoginStudente() throws IOException {
        MainGui.setRoot("login studente");

    }
    @FXML
    public void handleBtnBackToLoginHome() throws IOException {
        MainGui.setRoot("login home");
    }

    @FXML
    public void confermaRegistrazioneProfessore() throws IOException {
        Professore professore = new Professore();
        professore.setNome(nome.getText());
        professore.setCognome(cognome.getText());
        professore.setMatricola(matricola.getText());
        professore.setMail(mail.getText());
        professore.setPassword(password.getText());
        System.out.println(professore.toString());
        if(unibook.registraProfessore(professore, idUni.getText(), password.getText())){
            MainGui.setRoot("login home");
        }else{
            errorLabel.setVisible(true);
        }
    }
    @FXML
    public void confermaRegistrazioneStudente() throws IOException {
        Studente studente = new Studente();
        studente.setNome(nome.getText());
        studente.setCognome(cognome.getText());
        studente.setMatricola(matricola.getText());
        studente.setMail(mail.getText());
        studente.setPassword(password.getText());
        System.out.println(studente.toString());
        CorsoStudio cs = new CorsoStudio();
        cs.setId(corsostudio.getText());
        System.out.println(idUni.getText());
        System.out.println(matricola.getText());
        if(unibook.registraStudente(studente, idUni.getText(), cs, password.getText())){
            MainGui.setRoot("login home");
        }else{
            errorLabel.setVisible(true);
        }
    }

    @FXML
    public void confermaLoginStudente() throws IOException{
        Studente studente = new Studente();
        studente.setMatricola(matricolaLoginStudente.getText());
        studente.setPassword(passwordLoginStudente.getText());
        if(unibook.loginStudente(studente)){
            MainGui.setRoot("home studente");
        }else{
            errorLabel.setVisible(true);
        }

    }

    @FXML
    public void confermaLoginProfessore() throws IOException{
        Professore professore = new Professore();
        professore.setMatricola(matricolaloginProfessore.getText());
        professore.setPassword(passwordLoginProfessore.getText());
        if(unibook.loginProfessore(professore)){
            MainGui.setRoot("home professore");
        }else{
            errorLabel.setVisible(true);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
