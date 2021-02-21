package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class testPrenotaEsame {

    Unibook unibook;
    Universita u1;
    int index;

    @BeforeEach
    void setUp() {
        unibook = Unibook.getInstance();
    }

    @Test
    void prenotazioneEsame() {

        //---------FASE DI REGISTRAZIONE STUDENTE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Studente studente = new Studente("Flavio", "Condemi", "O46001668", "flavio.condemi@gmail.com");
        CorsoStudio cs = new CorsoStudio("Ingegneria Informatica");
        String cfuni = "eivwbtp394ut";

        cs.addStudente(studente);
        u1.addCorsostudio(cs);
        String password = "flavio";
        unibook.addUniversità(u1);
        unibook.registraStudente(studente, cfuni, cs, password);

        //---------FASE DI REGISTRAZIONE PROFESSORE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        u1.addProfessore(professore);

        String passwordProf = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, passwordProf);
        index = unibook.getListaprofessori().indexOf(professore);

        //---------FASE DI LOGIN-----------
        unibook.loginStudente(studente);
        unibook.loginProfessore(professore);

        //---------FASE DI CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        //---------FASE DI PRENOTAZIONE ESAME-----------

        unibook.prenotazioneEsame(esame.getId());
        int index = esame.getListaStudentiprenotati().indexOf(studente);
        assertEquals(studente, esame.getListaStudentiprenotati().get(index));
    }
}