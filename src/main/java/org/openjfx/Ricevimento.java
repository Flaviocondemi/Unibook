package org.openjfx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ricevimento  {

    private Long id;
    private String idprofessore;
    private String luogo;
    private int numerpartecipanti;
    private String data;
    private String deadline;
    private String orariofine;
    private String orarioinizio;
    private List<Studente> listaStudentiprenotati;
    private String titolo;


    public Ricevimento(String luogo, int numerpartecipanti, String data, String orariofine, String orarioinizio) {
        this.luogo = luogo;
        this.numerpartecipanti = numerpartecipanti;
        this.data = data;
        this.orariofine = orariofine;
        this.orarioinizio = orarioinizio;
        listaStudentiprenotati = new ArrayList<>();
        Random rand = new Random();
        id = (long) rand.nextInt(1000);
    }

    public Ricevimento() {

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Studente> getlistaStudentiprenotati() {
        return listaStudentiprenotati;
    }

    public void setlistaStudentiprenotati(List<Studente> listaStudentiprenotati) {
        this.listaStudentiprenotati = listaStudentiprenotati;
    }

    public Long getId() {
        return id;
    }

    public String getIdprofessore() {
        return idprofessore;
    }

    public void setIdprofessore(String idprofessore) {
        this.idprofessore = idprofessore;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public int getNumerpartecipanti() {
        return numerpartecipanti;
    }

    public void setNumerpartecipanti(int numerpartecipanti) {
        this.numerpartecipanti = numerpartecipanti;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getOrariofine() {
        return orariofine;
    }

    public void setOrariofine(String orariofine) {
        this.orariofine = orariofine;
    }

    public String getOrarioinizio() {
        return orarioinizio;
    }

    public void setOrarioinizio(String orarioinizio) {
        this.orarioinizio = orarioinizio;
    }

    @Override
    public String toString() {
        return "Ricevimento{" +
                "idprofessore='" + idprofessore + '\'' +
                ", luogo='" + luogo + '\'' +
                ", numerpartecipanti=" + numerpartecipanti +
                ", data='" + data + '\'' +
                ", deadline='" + deadline + '\'' +
                ", orariofine='" + orariofine + '\'' +
                ", orarioinizio='" + orarioinizio + '\'' +
                ", listaStudentiprenotati=" + listaStudentiprenotati +
                '}';
    }

    public void addStudente(Studente studente){
        listaStudentiprenotati.add(studente);
    }
}
