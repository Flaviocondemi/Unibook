package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class testRegistraProfessore {

    Unibook unibook;
    Universita u1;
    int index;

    @BeforeEach
    void setUp() {
        unibook = Unibook.getInstance();
    }
    @Test
    void registraProfessore() {

        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);
        index = unibook.getListaprofessori().indexOf(professore);
        assertEquals(professore, unibook.getListaprofessori().get(index));
    }

    @Test
    void testInserimentoMateria(){
        /*
        Il verificatore notifica ad UniBook un errore con l’inserimento di una materia
        o più materie inserite dall’utente:
         */

        //---------FASE DI REGISTRAZIONE-----------
        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        Professore professore = new Professore("Pietro", "Zamboni", "T0987834", "pietro.zamboni@gmail.com");
        String cfuni = "eivwbtp394ut";
        u1.addProfessore(professore);

        String password = "pietro";

        unibook.addUniversità(u1);
        unibook.registraProfessore(professore, cfuni, password);
        index = unibook.getListaprofessori().indexOf(professore);

        //---------FASE DI LOGIN-----------
        unibook.loginProfessore(professore);

        //---------FASE AGGIUNTA MATERIA-----------
        CorsoStudio cs = new CorsoStudio("Ingegneria Informatica");
        Materia materia = new Materia(9, "analisi");
        cs.addMateria(materia);
        unibook.inserisciMateria(materia, cs);
        int index = unibook.getProfessoreloggato().getListamaterie().indexOf(materia);

        assertEquals(materia, unibook.getProfessoreloggato().getListamaterie().get(index));
    }
}