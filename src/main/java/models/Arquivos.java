package main.java.models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.List;
import java.util.Arrays;
public class Arquivos {
    public static ArrayList<String[]> lerTxt(String arquivotxt){
        final String raizUsusario = System.getProperty("user.home");
        final String arquivo;
        if (arquivotxt == "candidatos.txt"){arquivo = "candidatos.txt";}
        else{arquivo = raizUsusario + arquivotxt;}
        ArrayList<String[]> linhas = new ArrayList<String[]>();
        Scanner leitor;
        try {
            leitor = new Scanner(new File(arquivo));
            while(leitor.hasNext()){
                String linha = leitor.next();
                if(linha.contains("Candidato:")){
                    String[] partes =  linha.split(",");
                    String candidato = partes[0].replace("Candidato:", "");
                    String id = partes[1].replace("Id:", "");
                    String[] valores = {candidato, id};
                    linhas.add(valores);
                }
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            return linhas;
        }
        return linhas;
    }
}