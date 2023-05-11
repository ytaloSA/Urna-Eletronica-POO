package main.java.controllers;

import java.util.ArrayList;

import main.java.models.Candidato;
import main.java.models.Voto;

public class Temp implements iArquivos {
    public static void main(String[] args) {
        ArrayList<String[]> dados = new ArrayList<String[]>();
        dados.add(new String[] {"Candidato:Biscoito", "Id:8"});
        dados.add(new String[] {"Candidato:Bolacha", "Id:7"});
        dados.add(new String[] {"Candidato:Pombo", "Id:101"});
        System.out.println(iArquivos.comparar("candidatos.txt", dados));
        
    }
}