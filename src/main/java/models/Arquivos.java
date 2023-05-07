package main.java.models;
import java.io.*;
import java.util.*;
public final class Arquivos {
    private static String localDeTrabalho(){return System.getProperty("user.dir");}
    public static ArrayList<String[]> lerTxtNaoFormatado(String arquivotxt){
        final String localDeTrabalho = localDeTrabalho();
        final String caminho = localDeTrabalho+"/main/"+ arquivotxt;
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
                else if (linha.contains("Nome:")){
                    String[] partes = linha.split(",");
                    String nome = partes[0].substring(partes[0].indexOf(":")+1);
                    String nascimento = partes[1].substring(partes[1].indexOf(":")+1);
                    String hash = partes[2].substring(partes[2].indexOf(":")+1);
                    String[] valores = {nome,nascimento,hash};
                    linhas.add(valores);
                }
                else if (linha.contains("Votado:")){
                    String[] partes = linha.split(",");
                    String votado = partes[0].substring(partes[0].indexOf(":")+1);
                    String hash = partes[1].substring(partes[1].indexOf(":")+1);
                    String[] valores = {votado,hash};
                    linhas.add(valores);
                }
                else if (linha.contains("Controle:")){
                    String[] partes = linha.split(",");
                    String controle = partes[0].substring(partes[0].indexOf(":")+1);
                    String hash = partes[1].substring(partes[1].indexOf(":")+1);
                    String[] valores = {controle,hash};
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
    public static void escreverTxt(String arquivotxt,String[] dadosParaEscrever){
        String localDeTrabalho = localDeTrabalho();
        File arquivo = new File(localDeTrabalho+"/main/"+arquivotxt);
        Boolean existeArquivo = arquivo.exists();
        ArrayList<String[]> dados;
        if (existeArquivo){
            dados = Arquivos.lerTxtNaoFormatado(arquivotxt);
            dados.add(dadosParaEscrever);
        }
        else{
            dados = new ArrayList<String[]>();
            dados.add(dadosParaEscrever);
        }
            try{
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
                if (arquivotxt=="candidatos.txt"){
                    for (String[] linha:dados){
                        escritor.write("Candidato:"+linha[0]+",Id:"+linha[1]);
                        escritor.newLine();
                    }
                }
                else if (arquivotxt=="controle.txt"){
                    for (String[] linha:dados){
                        escritor.write("Controle:"+linha[0]+",hash:"+linha[1]);
                        escritor.newLine();
                    }
                }
                else if (arquivotxt=="votos.txt"){
                    for (String[] linha:dados){
                        escritor.write("Votado:"+linha[0]+",hash:"+linha[1]);
                        escritor.newLine();
                    }
                }
                else if (arquivotxt=="eleitores.txt"){
                    for (String[] linha:dados){
                        escritor.write("Nome:"+linha[0]+",hash:"+linha[1]);
                        escritor.newLine();
                    }
                }
                escritor.close();
                
            }
            catch (IOException e) {
                System.out.println("Impossível escrever");
            }
            catch (Exception e){
                System.out.println("Ops! algo deu errado");
                System.out.println("Verifique se os caminhos dos arquivos, os nomes para os mesmos e o formato está de acordo com os padrões");
            }
    }
    public static ArrayList<String[]> lerTxtFormatado(String arquivoTxt){
        final String localDeTrabalho = localDeTrabalho();
        final String caminho = localDeTrabalho+"/main/"+ arquivoTxt;
        ArrayList<String[]> linhas = new ArrayList<String[]>();
        try {
            Scanner leitor = new Scanner(new File(caminho));
            while (leitor.hasNext()) {
                String linha = leitor.next();
                linhas.add(linha.split(","));
            }
        } catch (Exception e) {
            System.out.println("Algo deu errado! Mas é assim mesmo, tente de novo");
        }
        return linhas;
    }
    public static Boolean compararDados(String arquivoTxt,ArrayList<String[]> dadosComparar){
        ArrayList<String[]> dado1 = lerTxtFormatado(arquivoTxt);
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
    public static void main(String[] args) {
        //String[] pombo = {"Pombo","10"};
        //escreverTxt("candidatos.txt", pombo);
        for(String[] linha:lerTxtFormatado("candidatos.txt")){
            System.out.println(linha);
            for(String palavra:linha){
                System.out.println(palavra);
            }
        }
    }
}