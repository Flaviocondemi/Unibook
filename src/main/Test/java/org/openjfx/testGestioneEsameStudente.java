package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGestioneEsameStudente {


    Unibook unibook;
    Universita u1;
    int index;

    @BeforeEach
    void setUp() {
        unibook = Unibook.getInstance();
    }

    @Test
    void rimuoviEsame() {

        //---------FASE DI REGISTRAZIONE PROFESSORE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);

        //---------FASE DI REGISTRAZIONE STUDENTE-----------

        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Studente studente = new Studente("Flavio", "Condemi", "O46001668", "flavio.condemi@gmail.com");
        CorsoStudio cs = new CorsoStudio("Ingegneria Informatica");

        cs.addStudente(studente);
        u1.addCorsostudio(cs);
        String passwordStudente = "flavio";
        unibook.addUniversità(u1);
        unibook.registraStudente(studente, cfuni, cs, password);

        //---------FASE DI LOGIN-----------

        unibook.loginProfessore(professore);
        unibook.loginStudente(studente);

        //---------FASE CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        //---------FASE PRENOTAZIONE ESAME-----------
        unibook.prenotazioneEsame(esame.getId());

        //---------FASE RIMOZIONE-----------
        unibook.rimuoviPrenotazioneEsame(esame.getId());

        int index = esame.getListaStudentiprenotati().indexOf(studente);

        assertEquals(-1, index);

    }

}
