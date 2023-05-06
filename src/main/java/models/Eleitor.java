package main.java.models;
public final class Eleitor extends Participante{
    String dataNascimento;
    public Eleitor(String nomeParticipante, String dataNascimento){
        super(nomeParticipante);
        this.dataNascimento=dataNascimento;
    }
}