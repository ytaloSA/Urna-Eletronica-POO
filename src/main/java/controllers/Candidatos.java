package main.java.controllers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import main.java.models.Candidato;
 public final class Candidatos {
    protected static Hashtable<String, List<String>> gerar(){
        Hashtable<String,List<String>> candidatos;
        candidatos = new Hashtable<String, List<String>>();
        candidatos.put("Arroz por cima ou por baixo do feijão?",List.of("Por cima","Por baixo"));
        candidatos.put("É Biscoito ou Bolacha?",List.of("Biscoito","Bolacha"));
        candidatos.put("Qual o melhor?",List.of("Fifa","PES"));
        candidatos.put("Qual a melhor  Editora de Quadrinhos?",List.of("Marvel","DC"));
        candidatos.put("Xbox ou Playstaion?",List.of("Xbox","Playstation"));
        candidatos.put("Melhor plataforma de jogos",List.of("PC","Console","Mobile"));
        candidatos.put("Melhor Sistema Operacional de PC",List.of("Windows","Mac","Linux"));
        candidatos.put("Melhor versão do Windows",List.of("7","10","11"));
        candidatos.put("Carne mal passada é:",List.of("Crua","O melhor ponto"));
        candidatos.put("É Beiju ou Tapioca?",List.of("Beiju","Tapioca"));
        candidatos.put("Melhor Plataforma Mobile",List.of("Android","IOS"));
        candidatos.put("Melhor marca de Smartphone Android",List.of("Samsung","Xiaomi"));
        candidatos.put("Quem bota pra mamar?",List.of("AMD","Nvidia"));
        candidatos.put("Nintendo",List.of("Compra","Pirateia sem dó"));
        candidatos.put("Jogo Indie pode piratear?",List.of("Não. É imperdoável!","E qual é o problema?"));
        return candidatos;
    }
    protected static List<Candidato> candidatos(){
        List<Candidato> candidatos = new ArrayList<Candidato>();
        Hashtable<String,List<String>> dicionarioBase = gerar();
        Set<String> keys = dicionarioBase.keySet();
        for (String key : keys){
            Candidato candidato = new Candidato(key,dicionarioBase.get(key));
            candidatos.add(candidato);
        }
        return candidatos;
    }
    /** Como usar cada elemento separadamente
     * Use essa lógica para por o nome do candidato e suas opções na tela de votação
     * O trecho abaixo imprime separadamente cada um dos elementos
     * Serve apenas para entender a sintaxe
     * O código ficou maior que o esperado pois resolvi embutir a lista generica de candidatos no próprio código
    public static void main(String[] args) {
        List<Candidato> lista = candidatos();
        for (Candidato candidato:lista){
            System.out.println(candidato.titulo);
            System.out.println(candidato.dados);
        }
    }
    **/
}