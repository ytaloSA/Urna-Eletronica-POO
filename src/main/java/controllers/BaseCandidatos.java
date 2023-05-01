package main.java.controllers;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

 public final class BaseCandidatos {
    protected Hashtable<String,List<String>> candidatos;
    protected Hashtable<String, List<String>> gerar(){
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
    /**
     * Uma forma de processar separadamente cada elementeo do hashmap
     * Irei remover tudo em seguida e transformar em função
     */
    public static void main(String[] args) {
        BaseCandidatos base = new BaseCandidatos();
        Hashtable<String,List<String>> dicionarioBase = base.gerar();
        Set<String> keys = dicionarioBase.keySet();
        for (String key : keys){
            System.out.println(key+" "+dicionarioBase.get(key)+"\n");
        }
        System.out.println(base.gerar());
    }
}