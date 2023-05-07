package main.java.models;
import java.io.*;
import java.util.*;
public final class Arquivos {
    public static ArrayList<String[]> lerTxt(String arquivotxt){
        final String diretorioDeTrabalho = System.getProperty("user.dir");
        final String caminho;
        caminho = diretorioDeTrabalho+"/main/"+ arquivotxt;
        System.out.println("Arquivo: " + caminho);
        //if (arquivotxt == "candidatos.txt"){arquivo = "candidatos.txt";}
        //else{arquivo = raizUsusario + arquivotxt;}
        ArrayList<String[]> linhas = new ArrayList<String[]>();
        Scanner leitor;
        try {
            leitor = new Scanner(new File(caminho));
            while(leitor.hasNext()){
                String linha = leitor.next();
                if(linha.contains("Candidato:")){
                    String[] partes =  linha.split(",");
                    String candidato = partes[0].substring(partes[0].indexOf(":")+1);
                    String id = partes[1].substring(partes[1].indexOf(":")+1);
                    String[] valores = {candidato,id};
                    linhas.add(valores);
                }
                if (linha.contains("Nome:")){
                    String[] partes = linha.split(",");
                    String nome = partes[0].substring(partes[0].indexOf(":")+1);
                    String nascimento = partes[1].substring(partes[1].indexOf(":")+1);
                    String hash = partes[2].substring(partes[2].indexOf(":")+1);
                    String[] valores = {nome,nascimento,hash};
                    linhas.add(valores);
                }
                if (linha.contains("Votado:")){
                    String[] partes = linha.split(",");
                    String votado = partes[0].substring(partes[0].indexOf(":")+1);
                    String hash = partes[1].substring(partes[1].indexOf(":")+1);
                    String[] valores = {votado,hash};
                    linhas.add(valores);
                }
                if (linha.contains("votosHash:")){
                    String[] valores = {linha.substring(linha.indexOf(":")+1)};
                    linhas.add(valores);
                }
                if (linha.contains("eleitoresHash:")){
                    String[] valores = {linha.substring(linha.indexOf(":")+1)};
                    linhas.add(valores);
                }
            }
            leitor.close();
            return linhas;
        } catch (FileNotFoundException e) {
            return linhas;
        }
        catch(Exception e){
            return linhas;
        }
    }
    public static void escreverTxt(String arquivostxt){
        ArrayList<String[]> dados = Arquivos.lerTxt(arquivostxt);
        for (String[] linha:dados){
            
        }
    }
}