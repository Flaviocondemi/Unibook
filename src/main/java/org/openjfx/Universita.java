package org.openjfx;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Universita {
    private Long id;
    private String codicefiscale;
    private String nome;
    private String indirizzo;

    private List<Professore> listaprofessori;
    private List<CorsoStudio> listacorsodistudi;

    public Universita(String codicefiscale, String nome, String indirizzo) {
        this.codicefiscale = codicefiscale;
        this.nome = nome;
        this.indirizzo = indirizzo;
        listaprofessori = new ArrayList<>();
        listacorsodistudi = new ArrayList<>();
        System.out.println("Università creata");
    }

    public Universita(){

    }

    public List<Professore> getListaprofessori() {
        return listaprofessori;
    }

    public void setListaprofessori(List<Professore> listaprofessori) {
        this.listaprofessori = listaprofessori;
    }

    public List<CorsoStudio> getListacorsodistudi() {
        return listacorsodistudi;
    }

    public void setListacorsodistudi(List<CorsoStudio> listacorsodistudi) {
        this.listacorsodistudi = listacorsodistudi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void addProfessore(Professore professore){
        listaprofessori.add(professore);
    }

    public void addCorsostudio(CorsoStudio corsoStudio){
        listacorsodistudi.add(corsoStudio);
        System.out.println("Corso di studi aggiunto");
    }

}
