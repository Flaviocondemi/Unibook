package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class MainGui extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login home"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainGui.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static void initData(){
        //-------CONFIGURAZIONE DEI DATI INIZIALI
        /*
        Questo metodo deve essere fatto partire all'inizio, in quanto non è
        stato implementato alcun sistema per la gestione dei dati persistenti
        e per la convalida delle università. Verranno quindi create delle
        università 'finte' per simulare la verifica dell'effettiva iscrizione dello
        studente/professore in un data università
         */
        Unibook unibook = Unibook.getInstance();
        System.out.println("Start inizialiazzazione");
        Universita u1 = new Universita("U8888", "Unict", "santa sofia");
        CorsoStudio cs = new CorsoStudio("Ingegneria informatica");
        cs.setId("123");
        Studente s1 = new Studente("Flavio", "Condemi", "O46001668", "flavio.condemi@gmail.com");
        Studente s2 = new Studente("Ciccio", "Coco", "O46001664", "ciccio.coco@gmail.com");
        Studente s3 = new Studente("Leonardo", "diguardo", "O46001678", "leonardi.dig@gmail.com");
        Professore p1 = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        Professore p2 = new Professore("Giovanni", "cara", "T0989034", "giovanni.cata@gmail.com");
        Professore p3 = new Professore("Alessandra", "carioli", "T0987812", "alessandra.carioli@gmail.com");cs.addStudente(s1);

        cs.addStudente(s2);
        cs.addStudente(s3);
        u1.addCorsostudio(cs);
        u1.addProfessore(p1);
        u1.addProfessore(p2);
        u1.addProfessore(p3);
        unibook.addUniversità(u1);

    }

    public static void main(String[] args) {
        initData();
        launch();
    }

}