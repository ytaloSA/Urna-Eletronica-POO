package main.java.models;

public class Eleicao {
    private Candidato [] candidatos;
    private Eleitor [] eleitores;
    private Voto [] votos;
    private boolean aberta = true;

    public Eleicao() {
        
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos() {
        
    }

    public Eleitor[] getEleitores() {
        return eleitores;
    }

    public void setEleitores(Eleitor[] eleitores) {
        this.eleitores = eleitores;
    }

    public Voto[] getVotos() {
        return votos;
    }

    public void setVotos(Voto[] votos) {
        this.votos = votos;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }
}
