package org.openjfx;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class testRegistraStudente {
    Unibook unibook;
    Universita u1;
    Studente studente;
    CorsoStudio cs;
    int index;

    @BeforeEach
    void setUp() {
        unibook = Unibook.getInstance();
    }

    @Test
    void registraStudente() {

        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        studente = new Studente("Flavio", "Condemi", "O46001668", "flavio.condemi@gmail.com");
        cs = new CorsoStudio("Ingegneria Informatica");
        String cfuni = "eivwbtp394ut";

        cs.addStudente(studente);
        u1.addCorsostudio(cs);
        String password = "flavio";
        unibook.addUniversità(u1);
        unibook.registraStudente(studente, cfuni, cs, password);
        index = unibook.getListastudenti().indexOf(studente);
        assertEquals(studente, unibook.getListastudenti().get(index));
    }

    @Test
    void validitàCodiceFiscale(){
        /*
        Il verificatore notifica ad UniBook la non validità del codice fiscale
        dell’Università inserito dall’utente. Questo significa
        che l'utente che si vuole registrare ad unibook non è iscritto a quell'università
         */

        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        studente = new Studente("Flavio", "Condemi", "O46001668", "flavio.condemi@gmail.com");
        cs = new CorsoStudio("Ingegneria Informatica");

        String cfuni = "43445245"; // ---> codice fiscale errato
        cs.addStudente(studente);
        u1.addCorsostudio(cs);
        String password = "flavio";
        unibook.addUniversità(u1);
        unibook.registraStudente(studente, cfuni, cs, password);
        index = unibook.getListastudenti().indexOf(studente);
        assertEquals(-1, index); // ---> la lista deve essere vuota

    }

    @Test
    void validitàCorsoDiStudi(){
        /*
        Il verificatore notifica ad UniBook la non validità del codice fiscale
        del corso di studi inserito dall’utente. Questo significa
        che l'utente che si vuole registrare ad unibook non è iscritto a quel corso di studi
         */

        u1 = new Universita("eivwbtp394ut", "unict", "via santa sofia");
        studente = new Studente("Flavio", "Condemi", "O46001668", "flavio.condemi@gmail.com");
        cs = new CorsoStudio("Ingegneria meccanica");// ---> corso di studi sbagliato
        String cfuni = "eivwbtp394ut";

        cs.addStudente(studente);
        u1.addCorsostudio(cs);
        String password = "flavio";
        unibook.addUniversità(u1);
        unibook.registraStudente(studente, cfuni, cs, password);
        index = unibook.getListastudenti().indexOf(studente);
        assertEquals(-1, index); // ---> la lista deve essere vuota

    }
}