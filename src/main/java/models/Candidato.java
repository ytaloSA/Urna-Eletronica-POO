package main.java.models;
public final class Candidato extends Participante{
    String id;
    public Candidato(String nome, String id){
        super(nome);
        this.id = id;
    }
}