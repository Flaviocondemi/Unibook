package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGestioneEsameProfessore {

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

        //---------FASE DI LOGIN-----------
        unibook.loginProfessore(professore);

        //---------FASE CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        //---------FASE RIMOZIONE RICEVIMENTO-----------
        unibook.rimuoviEsame(esame);

        int index = unibook.getListaricevimenti().indexOf(esame);

        assertEquals(-1, index);

    }

    @Test
    void modificaEsame() {
        //---------FASE DI REGISTRAZIONE PROFESSORE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);

        //---------FASE DI LOGIN-----------
        unibook.loginProfessore(professore);

        //---------FASE CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        //---------FASE MODIFICA ESAME-----------
        //proviamo a modificare la data dell' esame
        Esame esamemodificato = new Esame("aula 5", 30, "20/06/2020", "17:30", "14:30", "Orale");
        unibook.modificaEsame(esame, esamemodificato);

        int index = unibook.getListaesami().indexOf(esamemodificato);
        assertEquals("20/06/2020", unibook.getListaesami().get(index).getData());
    }
}
