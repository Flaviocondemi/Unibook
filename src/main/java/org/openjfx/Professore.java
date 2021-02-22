package org.openjfx;

import java.util.ArrayList;
import java.util.List;

public class Professore {

    private String nome;
    private String cognome;
    private String mail;
    private String matricola;
    private String password;
    private Long id;
    private List<Materia> listamaterie;

    public Professore(){
        listamaterie = new ArrayList<>();
    }

    public Professore(String nome, String cognome, String matricola, String mail){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.mail = mail;
        listamaterie = new ArrayList<Materia>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void inserisciMateria(Materia materia){
        for(Materia materiaaggiunta : listamaterie){
            if(materiaaggiunta.getNome().equals(materia.getNome())){
                System.out.println("Materia già esistente");
                return;
            }
        }
        listamaterie.add(materia);
        System.out.println("Materia aggiunta");

    }

    public List<Materia> getListamaterie() {
        return listamaterie;
    }

    public void setListamaterie(List<Materia> listamaterie) {
        this.listamaterie = listamaterie;
    }

    @Override
    public String toString() {
        return "Professore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", matricola='" + matricola + '\'' +
                '}';
    }
}
