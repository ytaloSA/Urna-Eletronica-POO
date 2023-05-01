package main.java.models;

import java.util.ArrayList;

final class Eleitorado {
    ArrayList <Eleitor> eleitorado = new ArrayList<Eleitor>();
    public Eleitorado(Eleitor eleitor) {
        cadastrarEleitor(eleitor);
    }
    protected void cadastrarEleitor(Eleitor eleitor) {
        eleitorado.add(eleitor);
    }
    protected ArrayList<Eleitor> eleitores(){
        return eleitorado;
    }
}