package main.java.models;

import java.util.ArrayList;

public class Resultado {
    private String candidato;
    private int votosContagem;

    public Resultado(Candidato candidato, ArrayList<Voto> votos) {
        this.candidato = candidato.getNome();
        try {
            votosContagem = contarVotos(votos);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UnsupportedOperationException(ex.getMessage());
        }
    }

    private int contarVotos(ArrayList<Voto> votos) {
        int contador = 0;
        for (Voto voto : votos) {
            if (voto.getVoto() ==  candidato) {
                contador++;
            }
        }
        return contador;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public int getVotosContagem() {
        return votosContagem;
    }

    public void setVotosContagem(int votosContagem) {
        this.votosContagem = votosContagem;
    }
}
