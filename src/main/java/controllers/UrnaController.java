package main.java.controllers;

import main.java.view.*;

public class UrnaController implements iUrnaController {
    private UrnaEletronicaView telaUrna;
    private ResultadosView telaResultados;

    public UrnaController () {}

    public void iniciarVotacao() {
        telaUrna = new UrnaEletronicaView();
    }

    @Override
    public void carregarListaCandidatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarListaCandidatos'");
    }

    @Override
    public void carregarListaEleitores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarListaEleitores'");
    }

    @Override
    public void carregarEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarEleicao'");
    }

    @Override
    public void listarResultados() {
        telaResultados = new ResultadosView();
    }

    @Override
    public void carregarResultados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarResultados'");
    }

    @Override
    public void reiniciarEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reiniciarEleicao'");
    }

    @Override
    public void encerrarEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encerrarEleicao'");
    }

    @Override
    public void autorizarEleitor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autorizarEleitor'");
    }

    @Override
    public void carregarModuloMesario() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarModuloMesario'");
    }

    @Override
    public void inserirCandidato() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirCandidato'");
    }

    @Override
    public void inserirEleitor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirEleitor'");
    }

    @Override
    public void inserirEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirEleicao'");
    }
}