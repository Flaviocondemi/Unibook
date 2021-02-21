package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class testCreaRicevimento {

    Unibook unibook;
    Universita u1;
    int index;

    @BeforeEach
    void setUp() {
        unibook = Unibook.getInstance();
    }

    @Test
    void creaRicevimento() {

        //---------FASE DI REGISTRAZIONE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);

        //---------FASE DI CREAZIONE RICEVIMENTO-----------
        Ricevimento ricevimento = new Ricevimento("aula 5", 30, "15/06/2020", "17:30", "14:30");
        unibook.loginProfessore(professore);
        unibook.creaRicevimento(ricevimento);

        int index = unibook.getListaricevimenti().indexOf(ricevimento);
        assertEquals(ricevimento, unibook.getListaricevimenti().get(index));
        assertEquals(professore.getMatricola(), unibook.getListaricevimenti().get(index).getIdprofessore());

    }

    @Test
    void validitàDataRicevimento(){
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

        //---------FASE DI CREAZIONE ESAME-----------
        Esame esame = new Esame("aula 5", 30, "15/06/2020", "17:30", "14:30", "Orale");
        unibook.creaEsame(esame);

        //---------FASE DI CREAZIONE RICEVIMENTO-----------
        Ricevimento ricevimento = new Ricevimento("aula 5", 30, "15/06/2020", "17:30", "14:30");
        unibook.creaRicevimento(ricevimento);

        int index = unibook.getListaricevimenti().indexOf(ricevimento);

        assertEquals(-1, unibook.getListaricevimenti().indexOf(ricevimento));
    }
}