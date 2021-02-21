package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class testCreaEsame {

    Unibook unibook;
    Universita u1;

    @BeforeEach
    void setUp() {
        unibook = Unibook.getInstance();
    }

    @Test
    void creaEsame() {

        //---------FASE DI REGISTRAZIONE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);

        //---------FASE DI LOGIN PROFESSORE-----------
        unibook.loginProfessore(professore);

        //---------FASE CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        //---------FASE CREAZIONE ESAME-----------
        int index = unibook.getListaesami().indexOf(esame);
        assertEquals(esame, unibook.getListaesami().get(index));
        assertEquals(professore.getMatricola(), unibook.getListaesami().get(index).getIdprofessore());
    }

    @Test
    void validitàDataEsame(){

        unibook = Unibook.getInstance();
        //---------FASE DI REGISTRAZIONE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);

        //---------FASE DI LOGIN PROFESSORE-----------
        unibook.loginProfessore(professore);

        //---------FASE DI CREAZIONE RICEVIMENTO-----------
        Ricevimento ricevimento = new Ricevimento("aula 5", 30, "15/06/2020", "17:30", "14:30");
        unibook.creaRicevimento(ricevimento);

        //---------FASE CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        int index = unibook.getListaesami().indexOf(esame);

        assertEquals(-1, index);

    }
}