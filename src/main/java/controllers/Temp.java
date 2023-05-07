package main.java.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.models.Arquivos;

public class Temp implements iArquivos {
    public static void main(String[] args) {
        String dado1 = "candidatos.txt";
        ArrayList<String[]> dado2 = Arquivos.lerArquivoFormatado(dado1);
        ArrayList<String[]> dado3 = new ArrayList<String[]>();
        dado3.add(new String[] {"Candidato:Biscoito", "Id:8"});
        dado3.add(new String[] {"Candidato:Bolacha", "Id:7"});
        dado3.add(new String[] {"Candidato:Pombo", "Id:10"});
        System.out.println(iArquivos.compararArquivos("candidatos.txt", dado3));
    }
}