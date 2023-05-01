package main.java.models;

import java.util.List;

public abstract class Pessoa{
    public String titulo;
    public List<String> dados;
    public Pessoa(String titulo, List<String> dados) {
        this.titulo=titulo;
        this.dados=dados;
    }
}