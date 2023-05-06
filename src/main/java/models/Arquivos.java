package main.java.models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Arquivos {
    public static void lerTxt(String arquivotxt){
        final String raizUsusario = System.getProperty("user.home");
        final String arquivo = raizUsusario + arquivotxt;
        ArrayList<String> linhas = new ArrayList<String>();
        try {
            FileReader file = new FileReader(arquivo);
            BufferedReader leitor = new BufferedReader(file);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
