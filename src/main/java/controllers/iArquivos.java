package main.java.controllers;
import java.util.ArrayList;
import java.util.Arrays;

import main.java.models.Arquivos;
public interface iArquivos {
    public static Boolean compararArquivos(String arquivoTxt,ArrayList<String[]> dadosComparar){
        ArrayList<String[]> dado1 = Arquivos.lerArquivoFormatado(arquivoTxt);
        ArrayList<String[]> dado2 = dadosComparar;
        ArrayList<String> lista1 = new ArrayList<String>();
        ArrayList<String> lista2 = new ArrayList<String>();
        for(String[] linha:dado1){
            lista1.add(Arrays.toString(linha));
        }
        for(String[] linha:dado2){
            lista2.add(Arrays.toString(linha));
        }
        return lista1.equals(lista2);
    }
    public static void escreverArquivo(String arquivos, String[] dadosParaEscrever){
        Arquivos.escreverTxt(arquivos,dadosParaEscrever);
    }
    public static ArrayList<String[]> lerArquivoNaoFormatado(String arquivo){
        return Arquivos.lerTxtNaoFormatado(arquivo);
    }
}