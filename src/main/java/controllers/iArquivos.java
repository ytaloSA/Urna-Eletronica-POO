package main.java.controllers;
import java.util.ArrayList;
import main.java.models.Arquivos;
public interface iArquivos {
    public static Boolean compararArquivos(String arquivoTxt,ArrayList<String[]> dadosComparar){
        return dadosComparar.equals(lerArquivo(arquivoTxt));
    }
    public static void escreverArquivo(String arquivos, String[] dadosParaEscrever){
        Arquivos.escreverTxt(arquivos,dadosParaEscrever);
    }
    public static ArrayList<String[]> lerArquivo(String arquivo){
        return Arquivos.lerTxt(arquivo);
    }
}