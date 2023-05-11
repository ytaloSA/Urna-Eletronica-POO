package main.java.models;

import main.java.models.utils.GeradorId;

public class Voto {
    private String id;
    private String voto;

    
    public Voto(String voto) {
        this.voto = voto;
        id = GeradorId.getId();
    }

    public Voto(String voto, String id) {
        this.voto = voto;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
