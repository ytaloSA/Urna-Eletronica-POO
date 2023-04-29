public class UrnaMainView {

    private static boolean janelaAberta = false;

    public static void main(String[] args) {
        if (!janelaAberta) {
            UrnaEletronicaView janela = new UrnaEletronicaView();
            System.out.println("Caminho: " + System.getProperty("user.dir"));
            janela.setVisible(true);
            janelaAberta = true;
        }
    }
}
