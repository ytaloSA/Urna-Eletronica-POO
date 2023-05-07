package main.java.controllers;

public interface iUrnaController {
    void carregarListaCandidatos();
    void carregarListaEleitores();
    void carregarEleicao();
    void iniciarVotacao();
    void listarResultados();
    void carregarResultados();
    void reiniciarEleicao();
    void encerrarEleicao();
    void autorizarEleitor();
    void carregarModuloMesario();
    void inserirCandidato();
    void inserirEleitor();
    void inserirEleicao();
}
