package main.java.view.component;

public class ButtonUrnaNumerico extends ButtonUrna {
    
    public ButtonUrnaNumerico(String nome, String caminho) {
        super(nome, caminho);
        keyName = nome.substring(1, 2);
    }
}
