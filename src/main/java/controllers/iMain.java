package main.java.controllers;
import main.java.models.*;
public interface iMain extends iArquivos, iCriptografia{
    public static void criarJanelaPrincipal(){}
    public static void criarJanelaDeErro(){}
    public static void iniciarVotacao(){}
    public static void encerrarVotacao(){}
    public static void cadastrarCandidato(){}
    public static void cadastrarEleitor(){}
    public static void verificacaoInicial(){}
    public static void continuarVotacao(){}
    public static void proximoEleitor(){}
}