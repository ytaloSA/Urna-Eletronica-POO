package main.java.views;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;

public class VisorView extends JPanel {
    private int numerosCargo;
    private JLabel tituloEleicao;
    private JLabel[] numeroContainer;

    public VisorView(int num, String cargo) {
        super(null);
        numerosCargo = num;
        numeroContainer = new JLabel[numerosCargo];
        tituloEleicao = new JLabel("Enquete Polêmica: " + cargo);
        
        // Obtendo as dimensões do visor
        int visorWidth = this.getSize().width;
        int visorHeight = this.getSize().height;

        // obtendo as dimensões do botão
        int tituloEleicaoWidth = tituloEleicao.getPreferredSize().width;
        int tituloEleicaoHeight = tituloEleicao.getPreferredSize().height;

        // calculando as coordenadas x e y do botão para centralizá-lo
        int x = (547 - tituloEleicaoWidth) / 2;
        int y = (319 - tituloEleicaoHeight) / 2;

        // definindo as coordenadas x e y do botão
        tituloEleicao.setBounds(x, 50, tituloEleicaoWidth, tituloEleicaoHeight);

        add(tituloEleicao);

        int width = (547 - (30*(numerosCargo))) / 2;
        for (int c = 0; c < numerosCargo; c++) {
            numeroContainer[c] = new JLabel("");
            Border borda = BorderFactory.createLineBorder(Color.BLACK, 1);
            numeroContainer[c].setBorder(borda);
            numeroContainer[c].setBounds(x + (c*35), y, 30, 30);
            add(numeroContainer[c]);
        }
    }
}