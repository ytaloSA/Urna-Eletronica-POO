package main.java.controllers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import main.java.models.Candidato;
 public final class Candidatos {
    protected static Hashtable<String, List<String>> gerar(){
        Hashtable<String,List<String>> genericos;
        genericos = new Hashtable<String, List<String>>();
        genericos.put("Arroz por cima ou por baixo do feijão?",List.of("Por cima","Por baixo"));
        genericos.put("É Biscoito ou Bolacha?",List.of("Biscoito","Bolacha"));
        genericos.put("Qual o melhor?",List.of("Fifa","PES"));
        genericos.put("Qual a melhor  Editora de Quadrinhos?",List.of("Marvel","DC"));
        genericos.put("Xbox ou Playstaion?",List.of("Xbox","Playstation"));
        genericos.put("Melhor plataforma de jogos",List.of("PC","Console","Mobile"));
        genericos.put("Melhor Sistema Operacional de PC",List.of("Windows","Mac","Linux"));
        genericos.put("Melhor versão do Windows",List.of("7","10","11"));
        genericos.put("Carne mal passada é:",List.of("Crua","O melhor ponto"));
        genericos.put("É Beiju ou Tapioca?",List.of("Beiju","Tapioca"));
        genericos.put("Melhor Plataforma Mobile",List.of("Android","IOS"));
        genericos.put("Melhor marca de Smartphone Android",List.of("Samsung","Xiaomi"));
        genericos.put("Quem bota pra mamar?",List.of("AMD","Nvidia"));
        genericos.put("Nintendo",List.of("Compra","Pirateia sem dó"));
        genericos.put("Jogo Indie pode piratear?",List.of("Não. É imperdoável!","E qual é o problema?"));
        return genericos;
    }
    public List<Candidato> obterCandidatosGenericos(){
        List<Candidato> candidatos = new ArrayList<Candidato>();
        Hashtable<String,List<String>> dicionarioBase = gerar();
        Set<String> keys = dicionarioBase.keySet();
        for (String key : keys){
            Candidato candidato = new Candidato(key,dicionarioBase.get(key));
            candidatos.add(candidato);
        }
        return candidatos;
    }
}