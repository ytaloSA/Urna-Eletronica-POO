package main.java.models;

import java.util.Hashtable;
import java.util.List;

final class BaseCandidatos {
    protected Hashtable<String,List<String>> candidatos;
    protected Hashtable gerar(){
        candidatos = new Hashtable<String, List<String>>();
        candidatos.put("Arroz por cima ou por baixo do feijão?",List.of("Por cima","Por baixo"));
        candidatos.put("É Biscoito ou Bolacha?",List.of("Biscoito","Bolacha"));
        candidatos.put("Qual o melhor?",List.of("Fifa","PES"));
        return candidatos;
    }
}
