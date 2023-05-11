package main.java.models;

public final class Candidato extends Participante{
    private String numero;

    public Candidato(String nome, String id){
        super(nome);
        this.numero = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}