package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UrnaEletronicaView extends JFrame implements iUrnaEletronicaView {
    /**
     * Variável de controle para impedir duas ou mais janelas simultâneas
     */
    private static Boolean janelaAberta = false;

    /**
     * Array para armazenas botões da urna e o caminho das respectivas imagens
     */
    private ButtonUrna [] buttons = new ButtonUrna[13];
    
    /**
     * Objetos que armazenam os caminhos das imagens da urna
     */
    private ImageIcon itela, itopo, ifaixaDir, iladoEsqTec, iladoDirTec, iptaBaixo7, iptaBaixo9, iabaixoTec;

    /**
     * Label's para visualização das imagens da urna
     */
    private JLabel jLtela, jLtopo, jLfaixaDir, jLladoEsqTec, jLladoDirTec, jLptaBaixo7, jLptaBaixo9, jLabaixoTec;
    
    /**
     * Conteiner principal da aplicação.
     */
    private JPanel panel;

    /**
     * Tela do visor do momento de votação no layout de urna
     */
    private VisorVotacaoView visorVotacao;

    /**
     * Armazenamento do caminho do projeto para construção de caminho relativo.
     */
    private String caminhoImages;

    public UrnaEletronicaView () {
        
        /**
         * Verifica se há janela aberta
         */
        if (!janelaAberta) {
            /**
             * Definição das propriedades da tela e instanciação do panel principal
             */
            setSize(500,500);
            setExtendedState(MAXIMIZED_BOTH);
            
            /**
             * Instânciando container principal
             */
            panel = new JPanel(null);
            panel.setBackground(Color.WHITE);
            add(panel);
            
            /**
             * Instânciando container do visor da urna
             */
            visorVotacao = new VisorVotacaoView("Bolacha x Biscoito");
            visorVotacao.setBounds(50, 207, 547, 319);
            visorVotacao.setBackground(Color.WHITE);
            panel.add(visorVotacao);

            setCaminhoImages();
            
            /**
             * Instanciando os botões de 0 a 9
             */
            for (int c = 0; c <= 9; c++) {
                buttons[c] = new ButtonUrnaNumerico("n" + c, caminhoImages);
            }

            /**
             * Instanciando os botões especiais: Branco, Corrige e Confirma
             */
            buttons[10] = new ButtonUrnaAction("branco", caminhoImages);
            buttons[11] = new ButtonUrnaAction("corrige", caminhoImages);
            buttons[12] = new ButtonUrnaAction("confirma", caminhoImages);

            adicionarListenes();

            /**
             * Instanciando objetos que armazenam o caminho das imagens da urna
             */
            itela = new ImageIcon(caminhoImages + "tela.jpg");
            itopo = new ImageIcon(caminhoImages + "topo.jpg");
            ifaixaDir = new ImageIcon(caminhoImages + "faixaDir.jpg");
            iladoEsqTec = new ImageIcon(caminhoImages + "ladoEsqTec.jpg");
            iladoDirTec = new ImageIcon(caminhoImages + "ladoDirTec.jpg");
            iptaBaixo7 = new ImageIcon(caminhoImages + "ptaBaixo7.jpg");
            iptaBaixo9 = new ImageIcon(caminhoImages + "ptaBaixo9.jpg");
            iabaixoTec = new ImageIcon(caminhoImages + "abaixoTec.jpg");
            
            /**
             * Instanciando os componentes JLabel que servirá como contêiner para as imagens da urna
             */
            jLtela = new JLabel(itela);
            jLtopo = new JLabel(itopo);
            jLfaixaDir = new JLabel(ifaixaDir);
            jLladoEsqTec = new JLabel(iladoEsqTec);
            jLladoDirTec = new JLabel(iladoDirTec);
            jLptaBaixo7 = new JLabel(iptaBaixo7);
            jLptaBaixo9 = new JLabel(iptaBaixo9);
            jLabaixoTec = new JLabel(iabaixoTec);

            /**
             * Adicionando os labels ao panel
             */
            panel.add(jLtela);
            panel.add(jLtopo);
            panel.add(jLfaixaDir);
            panel.add(jLladoEsqTec);
            panel.add(jLladoDirTec);
            panel.add(jLptaBaixo7);
            panel.add(jLptaBaixo9);
            panel.add(jLabaixoTec);

            setPositionComponents();

            /**
             * Atualização da variável de controle indicando que há uma janela aberta
             */
            janelaAberta = true;
        }
    }

    public void setCaminhoImages() {
        /**
         * Definindo o caminho relativo da aplicação com base na localização do diretório
         */
        String caminhoUser = System.getProperty("user.dir");
        this.caminhoImages = caminhoUser + "\\main\\resources\\urna\\images\\";
    }

    public void adicionarListenes() {
        /**
         * Adicionando ouvintes de eventos para o botão esquerdo do mouse para trocar as imagens dos botões para sua versão pressionada
         */
        for (int c = 0; c < buttons.length; c++) {
            panel.add(buttons[c]);
            final int index = c;
            buttons[c].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    buttons[index].setImageButton(true);
                    try {
                        String key = buttons[index].getKeyName();
                        JOptionPane.showMessageDialog(null, key);
                        if (buttons[index] instanceof ButtonUrnaNumerico) {
                            visorVotacao.incluirNumeroDigitado(key);
                        }
                        else {

                            if (key == "branco") {
                                votoBranco();
                            } else if (key == "corrige") {
                                visorVotacao.apagarNumeroDigitado();
                            } else {
                                votoConfirmado();
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    buttons[index].setImageButton(false);
                }
            });
            buttons[c].addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    if (buttons[index].contains(e.getPoint())) {
                        buttons[index].setImageButton(true);
                    } else {
                        buttons[index].setImageButton(false);
                    }
                }
            });
            setVisible(true);
        }
    }

    public void setPositionComponents() {
        /**
         * Definindo as posições na tela para cada parte de imagem da urna e os botões
         */
        jLtela.setBounds(0, 0, itela.getIconWidth(), itela.getIconHeight());

        jLtopo.setBounds(itela.getIconWidth(), -3, itopo.getIconWidth(), itopo.getIconHeight());

        jLfaixaDir.setBounds(itela.getIconWidth() + itopo.getIconWidth(), 32,ifaixaDir.getIconWidth(),ifaixaDir.getIconHeight());

        jLladoEsqTec.setBounds(itela.getIconWidth(), itopo.getIconHeight()-3, iladoEsqTec.getIconWidth(), iladoEsqTec.getIconHeight());

        buttons[1].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3, buttons[1].icon.getIconWidth(), buttons[1].icon.getIconHeight());

        buttons[2].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[1].icon.getIconWidth(), itopo.getIconHeight()-3, buttons[2].icon.getIconWidth(), buttons[2].icon.getIconHeight());

        buttons[3].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[1].icon.getIconWidth() + buttons[2].icon.getIconWidth(), itopo.getIconHeight()-3, buttons[3].icon.getIconWidth(), buttons[3].icon.getIconHeight());

        jLladoDirTec.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[1].icon.getIconWidth() + buttons[2].icon.getIconWidth() + buttons[3].icon.getIconWidth(), itopo.getIconHeight()-3, iladoDirTec.getIconWidth(), iladoDirTec.getIconHeight());

        buttons[4].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight(), buttons[4].icon.getIconWidth(), buttons[4].icon.getIconHeight());

        buttons[5].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[4].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight(), buttons[5].icon.getIconWidth(), buttons[5].icon.getIconHeight());

        buttons[6].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[5].icon.getIconWidth() + buttons[4].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight(), buttons[6].icon.getIconWidth(), buttons[6].icon.getIconHeight());

        buttons[7].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight(), buttons[7].icon.getIconWidth(), buttons[7].icon.getIconHeight());

        buttons[8].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[4].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight(), buttons[8].icon.getIconWidth(), buttons[8].icon.getIconHeight());

        buttons[9].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[4].icon.getIconWidth() + buttons[5].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight(), buttons[9].icon.getIconWidth(), buttons[9].icon.getIconHeight());
        
        jLptaBaixo7.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[9].icon.getIconHeight(), iptaBaixo7.getIconWidth(), iptaBaixo7.getIconHeight());
        
        buttons[0].setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + iptaBaixo7.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[9].icon.getIconHeight(), buttons[0].icon.getIconWidth(), buttons[0].icon.getIconHeight());
        
        jLptaBaixo9.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + iptaBaixo7.getIconWidth() + buttons[0].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[9].icon.getIconHeight(), iptaBaixo9.getIconWidth(), iptaBaixo9.getIconHeight());

        buttons[10].setBounds(itela.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo7.getIconHeight(), buttons[10].icon.getIconWidth(), buttons[10].icon.getIconHeight());
    
        buttons[11].setBounds(itela.getIconWidth() + buttons[10].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo7.getIconHeight(), buttons[11].icon.getIconWidth(), buttons[11].icon.getIconHeight());
    
        buttons[12].setBounds(itela.getIconWidth() + buttons[10].icon.getIconWidth() + buttons[11].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo9.getIconHeight(), buttons[12].icon.getIconWidth(), buttons[12].icon.getIconHeight());

        jLabaixoTec.setBounds(itela.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo7.getIconHeight() + buttons[10].icon.getIconHeight(), iabaixoTec.getIconWidth(), iabaixoTec.getIconHeight());
    }

    @Override
    public void votoConfirmado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'votoConfirmado'");
    }

    @Override
    public void votoBranco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'votoBranco'");
    }

    @Override
    public void votoNulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'votoNulo'");
    }
}