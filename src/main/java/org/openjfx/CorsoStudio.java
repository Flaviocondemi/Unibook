package org.openjfx;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

public class CorsoStudio {
    private String id;
    private String nome;
    private List<Materia> listamaterie;
    private List<Studente> listastudenti;

    public CorsoStudio(String nome) {
        this.nome = nome;
        listamaterie = new ArrayList<>();
        listastudenti = new ArrayList<>();
    }

    public CorsoStudio() {

    }

    public List<Materia> getListamaterie() {
        return listamaterie;
    }

    public void setListamaterie(List<Materia> listamaterie) {
        this.listamaterie = listamaterie;
    }

    public List<Studente> getListastudenti() {
        return listastudenti;
    }

    public void setListastudenti(List<Studente> listastudenti) {
        this.listastudenti = listastudenti;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addMateria(Materia materia){
        listamaterie.add(materia);
        System.out.println("materia aggiunta");
    }

    public void addStudente(Studente studente){
        listastudenti.add(studente);
        System.out.println("Studente aggiunto");
    }
}
