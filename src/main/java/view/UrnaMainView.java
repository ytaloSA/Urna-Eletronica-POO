package main.java.view;
public class UrnaMainView {

    private static boolean janelaAberta = false;

    public static void main(String[] args) {
        if (!janelaAberta) {
            UrnaEletronicaView janela = new UrnaEletronicaView();
            janela.setVisible(true);
            janelaAberta = true;
        }
    }
}
