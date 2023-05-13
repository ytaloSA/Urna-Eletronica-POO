package main.java.controllers;

import java.util.ArrayList;

import main.java.models.Resultado;

public interface iUrnaController {
    void carregarListaCandidatos();
    void carregarListaEleitores();
    void carregarEleicao();
    void iniciarVotacao();
    void listarResultados();
    void abrirModuloMesario();
    ArrayList<Resultado> carregarResultados();
    void reiniciarEleicao();
    void encerrarEleicao();
    void validarEleitor();
    void autorizarEleitor();
    void inserirCandidato();
    void inserirEleitor(String nome, String nascimento);
    void inserirEleicao();
    void registrarVoto(String voto);
}
