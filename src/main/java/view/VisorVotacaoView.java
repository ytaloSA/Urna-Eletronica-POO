package main.java.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Classe para gerar o visor da urna eletrônica.
 */
public class VisorVotacaoView extends JPanel {
    private String cargo;
    private int numerosCargo;
    private JLabel tituloEleicao, jlImgCandidato, jlNome;
    private JLabel[] numeroContainer;
    private String numeroDigitado;
    private JPanel panelPrincipal, panelCandidato, panelFim, jpInstructions;
    private CardLayout cardLayout;
    private ImageIcon iImgCandidato;
    private String caminhoImages;

    /**
     * Construtor sobrecarregado em que o paramêtro cargo é obrigatório e num é opcional
     * @param cargo é o título da eleição
     * @param num é o número de caracteres que cada candidato possui em sua numeração de identificação. Portanto, se a eleição é com candidatos que possuem dois digitos (00 até 99) o "num" é 2.
     */
    public VisorVotacaoView(String cargo) {
        super(null);
        ConstruirVisor(3, cargo, 50, 207, 547, 319);
    }

    
    public VisorVotacaoView(int num, String cargo) {
        super(null);
        ConstruirVisor(num, cargo, 50, 207, 547, 319);
    }

    public VisorVotacaoView(int num, String cargo, int x, int y, int width, int height) {
        super(null);
        ConstruirVisor(num, cargo, x, y, width, height);
    }

    public void ConstruirVisor(int num, String cargo, int x, int y, int width, int height) {
        this.cargo = cargo;
        numerosCargo = num;
        numeroContainer = new JLabel[numerosCargo];
        numeroDigitado = "";
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        setBounds(x, y, width, height);
        setCaminhoImages();

        panelPrincipal = new JPanel(null);
        panelPrincipal.setSize(this.getWidth(), this.getHeight());
        contruirPanelPrincipal(panelPrincipal);
        esconderDadosVoto();
        
        panelFim = new JPanel(null);
        panelFim.setSize(this.getWidth(), this.getHeight());
        construirPanelFim(panelFim);
        
        add(panelPrincipal, "panelPrincipal");
        add(panelFim, "panelFim");
        
        cardLayout.show(this, "panelPrincipal");
        //cardLayout.show(this, "panelFim");
    }

    public void setCaminhoImages() {
        /**
         * Definindo o caminho relativo da aplicação com base na localização do diretório
         */
        String caminhoUser = System.getProperty("user.dir");
        this.caminhoImages = caminhoUser + "\\main\\resources\\candidatos\\images\\";
    }

    public void contruirPanelPrincipal(JPanel panel) {
        tituloEleicao = new JLabel(cargo);        
        int [] dim = calcularCoordenadasComponent(tituloEleicao);
        tituloEleicao.setBounds(dim[0], 50, dim[2], dim[3]);
        generateLabelsDigitos(panel,dim[0], dim[1]);

        System.out.println(caminhoImages);
        iImgCandidato = new ImageIcon(caminhoImages + "Bolacha.png");
        jlImgCandidato = new JLabel(iImgCandidato);
        int x = getWidth() - iImgCandidato.getIconWidth();
        int y = 0;
        jlImgCandidato.setBounds(x, y, iImgCandidato.getIconWidth(), iImgCandidato.getIconHeight());
        
        jlNome = new JLabel("BOLACHA");
        Font font = jlNome.getFont();
        Font fontGrande = font.deriveFont(font.getSize() + 30f);
        jlNome.setFont(fontGrande);
        dim = calcularCoordenadasComponent(jlNome);
        jlNome.setBounds(dim[0], dim[1]+dim[3], dim[2], dim[3]);

        jpInstructions = new JPanel();
        jpInstructions.setBounds(1, 270, 365, 100);

        JLabel lAperte = new JLabel("Aperte a tecla:");
        lAperte.setBounds(5, 0, 150, 20);
        
        JLabel lConfirma = new JLabel("CONFIRMA para CONFIRMAR este voto");
        lConfirma.setBounds(100, 15, 200, 20);
        
        JLabel lCorrige = new JLabel("CORRIGE para REINICIAR este voto");   
        lCorrige.setBounds(0, 30, 95, 20);

        jpInstructions.add(lAperte);
        jpInstructions.add(lConfirma);
        jpInstructions.add(lCorrige);

        panel.add(jlImgCandidato);
        panel.add(tituloEleicao);
        panel.add(jlNome);
        panel.add(jpInstructions);
    }

    public void construirPanelFim(JPanel panel) {
        JLabel fimText = new JLabel("FIM");
        Font font = fimText.getFont();
        Font fontGrande = font.deriveFont(font.getSize() + 80f);
        fimText.setFont(fontGrande);
        int [] dim = calcularCoordenadasComponent(fimText);
        fimText.setBounds(dim[0], dim[1], dim[2], dim[3]);
        panel.add(fimText);
    }

    /**
     * O método calcula o tamanho e localização de um componente para centralizá-lo em relação ao componente pai
     * @param component é um componente Java Swing
     * @return é um array de 4 inteiros, sendo composto pela coordenada x, coordenada y, larguta e altura, respectivamente
     */
    private int [] calcularCoordenadasComponent(Component component) {
        // obtendo as dimensões do titulo
        int componentWidth = component.getPreferredSize().width;
        int componentHeight = component.getPreferredSize().height;
        int visorWidth = getWidth();
        int visorHeigth = getHeight();
        
        // calculando as coordenadas x e y do titulo para centralizá-lo
        int x = (visorWidth - componentWidth) / 2;
        int y = (visorHeigth - componentHeight) / 2;

        int [] coordenadas = { x , y, componentWidth, componentHeight };

        return coordenadas;
    }

    /**
     * Método responsável por gerar e posicionar os labels que receberão os números digitados pelo usuário.
     * @param x coordenada horizontal de referência para posicionamento inicial dos labels.
     * @param y coordenada vertical de referência para posicionamento inicial dos labels.
     */
    private void generateLabelsDigitos(JPanel panel,int x, int y) {
        for (int c = 0; c < numerosCargo; c++) {
            numeroContainer[c] = new JLabel("");
            Border borda = BorderFactory.createLineBorder(Color.BLACK, 1);
            numeroContainer[c].setBorder(borda);
            numeroContainer[c].setBounds(x + (c*35), y, 30, 30);
            numeroContainer[c].setHorizontalAlignment(SwingConstants.CENTER);;
            panel.add(numeroContainer[c]);
        }
    }

    /**
     * Método responsável por escrever o número digitado na tela.
     * @param s é uma string contendo um caractere corresponde as teclas de 0 a 9 da urna.
     */
    public void incluirNumeroDigitado(String s) {
        if (numeroDigitado.length() == numeroContainer.length) {
            throw new UnsupportedOperationException("Limite de números para o candidato atingido. Verifique a numeração inserida e digite CONFIRMA para finalizar ou CORRIGE para reiniciar.");
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

    /**
     * Método responsável por remover o último caractere adicionado a tela
     */
    public void apagarNumeroDigitado() {
        if (numeroDigitado.length() == 0) {
            throw new UnsupportedOperationException("Não há digitos para apagar. Digite o número do seu candidato.");
        }
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
        for (int c = 0; c < numeroContainer.length; c++) {
            String str = "";
            if (c < numeroDigitado.length()) {
                StringBuilder sb = new StringBuilder();
                sb.append(numeroDigitado.charAt(c));
                str = sb.toString();
            }
            numeroContainer[c].setText(str);
        }
    }

    /**
     * Exibe os dados do voto do eleitor
     */
    public void mostrarDadosVoto() {
        jlImgCandidato.setVisible(true);
        jlNome.setVisible(true);
        jpInstructions.setVisible(true);
    }
    
    /**
     * Esconde os dados do voto do eleitor
     */
    public void esconderDadosVoto() {
        jlImgCandidato.setVisible(false);
        jlNome.setVisible(false);
        jpInstructions.setVisible(false);
    
    }

    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public int getNumerosCargo() {
        return numerosCargo;
    }


    public void setNumerosCargo(int numerosCargo) {
        this.numerosCargo = numerosCargo;
    }


    public JLabel getTituloEleicao() {
        return tituloEleicao;
    }


    public void setTituloEleicao(JLabel tituloEleicao) {
        this.tituloEleicao = tituloEleicao;
    }


    public JLabel[] getNumeroContainer() {
        return numeroContainer;
    }


    public void setNumeroContainer(JLabel[] numeroContainer) {
        this.numeroContainer = numeroContainer;
    }


    public String getNumeroDigitado() {
        return numeroDigitado;
    }


    public void setNumeroDigitado(String numeroDigitado) {
        this.numeroDigitado = numeroDigitado;
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }


    public JPanel getPanelCandidato() {
        return panelCandidato;
    }


    public void setPanelCandidato(JPanel panelCandidato) {
        this.panelCandidato = panelCandidato;
    }


    public JPanel getPanelFim() {
        return panelFim;
    }


    public void setPanelFim(JPanel panelFim) {
        this.panelFim = panelFim;
    }


    public CardLayout getCardLayout() {
        return cardLayout;
    }


    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }
}
