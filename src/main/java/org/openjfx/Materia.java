package org.openjfx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Materia {
    private Long id;
    private int cfu;
    private String nome;

    public Materia(int cfu, String nome) {
        this.cfu = cfu;
        this.nome = nome;
    }
    public Materia(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "cfu=" + cfu +
                ", nome='" + nome + '\'' +
                '}';
    }
}
