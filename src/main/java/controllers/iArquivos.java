package main.java.controllers;
import java.util.ArrayList;
import main.java.models.Arquivos;
public interface iArquivos {
    public static void compararArquivos(){}
    public static void escreverArquivo(String arquivos){
        Arquivos.escreverTxt(arquivos);
    }
    public static ArrayList<String[]> lerArquivo(String arquivo){
        return Arquivos.lerTxt(arquivo);
    }
}