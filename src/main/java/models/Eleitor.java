package main.java.models;
public final class Eleitor extends Pessoa {
    public Eleitor(String nome ,int id){
        this.eleitor=true;
        this.id=id;
        this.nome=nome;
    }
}