package main.java.models;
public abstract class Pessoa{
    public String nome;
    public int id;
    public Pessoa(String nome, int id) {
        this.nome=nome;
        this.id=id;
    }
}