package main.java.view;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Classe para gerar o visor da urna eletrônica.
 */

public class VisorVotacaoView extends JPanel {
    private int numerosCargo;
    private JLabel tituloEleicao;
    private JLabel[] numeroContainer;
    private String numeroDigitado;

    /**
     * Construtor sobrecarregado em que o paramêtro cargo é obrigatório e num é opcional
     * @param cargo é o título da eleição
     * @param num é o número de caracteres que cada candidato possui em sua numeração de identificação. Portanto, se a eleição é com candidatos que possuem dois digitos (00 até 99) o "num" é 2.
     */
    public VisorVotacaoView(String cargo) {
        super(null);
        ConstruirVisor(3, cargo);
    }

    
    public VisorVotacaoView(int num, String cargo) {
        super(null);
        ConstruirVisor(num, cargo);
    }

    public void ConstruirVisor(int num, String cargo) {
        numerosCargo = num;
        numeroContainer = new JLabel[numerosCargo];
        numeroDigitado = "";
        int [] dim = generateTitle(cargo);        
        generateLabelsDigitos(dim[0], dim[1]);
    }

    /**
     * 
     * O método é responsável por gerar e alinhar o texto título da votação.
     * @return um array contendo as coordenas x e y calculadas para definir o posicionamento dos botões em relação ao título da eleição
     */
    private int [] generateTitle(String cargo) {

        tituloEleicao = new JLabel("Enquete Polêmica: " + cargo);
        
        // obtendo as dimensões do titulo
        int tituloEleicaoWidth = tituloEleicao.getPreferredSize().width;
        int tituloEleicaoHeight = tituloEleicao.getPreferredSize().height;
        
        // calculando as coordenadas x e y do titulo para centralizá-lo
        int x = (547 - tituloEleicaoWidth) / 2;
        int y = (319 - tituloEleicaoHeight) / 2;

        // definindo as coordenadas x e y do titulo
        tituloEleicao.setBounds(x, 50, tituloEleicaoWidth, tituloEleicaoHeight);

        add(tituloEleicao);

        int [] dim = {x, y};

        return dim;
    }

    /**
     * Método responsável por gerar e posicionar os labels que receberão os números digitados pelo usuário.
     * @param x coordenada horizontal de referência para posicionamento inicial dos labels.
     * @param y coordenada vertical de referência para posicionamento inicial dos labels.
     */
    private void generateLabelsDigitos(int x, int y) {
        for (int c = 0; c < numerosCargo; c++) {
            numeroContainer[c] = new JLabel("");
            Border borda = BorderFactory.createLineBorder(Color.BLACK, 1);
            numeroContainer[c].setBorder(borda);
            numeroContainer[c].setBounds(x + (c*35), y, 30, 30);
            numeroContainer[c].setHorizontalAlignment(SwingConstants.CENTER);;
            add(numeroContainer[c]);
        }
    }

    /**
     * Método responsável por escrever o número digitado na tela.
     * @param s é uma string contendo um caractere corresponde as teclas de 0 a 9 da urna.
     */
    public void incluirNumeroDigitado(String s) {
        if (numeroDigitado.length() == numeroContainer.length) {
            throw new UnsupportedOperationException("Limite de números para o candidato atingido. Verifique a numeração inserida.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numeroDigitado);
        sb.append(s);
        numeroDigitado = sb.toString();
        atualizarTelaVotacao();
    }

    /**
     * Método responsável por limpar a string dos números digitados e chama o método para atualizar a tela.
     */
    public void redefinirNumeroDigitado() {
        numeroDigitado = "";
        atualizarTelaVotacao();
    }

    public void apagarNumeroDigitado() {
        StringBuilder sb = new StringBuilder();
        sb.append(numeroDigitado);
        sb.deleteCharAt((numeroDigitado.length()-1));
        numeroDigitado = sb.toString();
        atualizarTelaVotacao();
    }

    /**
     * Método que atualizar o conteúdo de texto dos labels dos números no visor da votação.
     */
    public void atualizarTelaVotacao() {
        for (int c = 0; c < numeroDigitado.length(); c++) {
            StringBuilder sb = new StringBuilder();
            sb.append(numeroDigitado.charAt(c));
            numeroContainer[c].setText(sb.toString());
        }
    }
}
