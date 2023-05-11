package main.java.view;

import javax.swing.*;
import main.java.controllers.*;
import main.java.view.util.MensagemDialogo;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

/**
 * Classe responsável por gerar a tela do menu principal da aplicação.
 */
public class MenuPrincipalView extends WindowView {
    private JPanel panel;
    private JButton votarBtn, mesarioBtn, resultadosBtn, sairBtn;
    private Background backgroundPanel;
    
    private class Background extends JPanel {
        private Image background;
        public Background() {
            String caminhoUser = System.getProperty("user.dir");
            String caminhoImages = caminhoUser + "\\main\\resources\\menu\\images\\";
            background = new ImageIcon(caminhoImages + "bolacha-ou-biscoito.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public MenuPrincipalView(UrnaController controller) {
        super();
        if (!janelaAberta) {
            WindowView.controller = controller;
            
            /**
             * Definição de propriedade da janela: título, tamanho, dimensões, layout, localização, plano de fundo
             */
            setTitle("Urna Eletrônica: Menu Principal");
            setSize(800,500);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);
            backgroundPanel = new Background();
            getContentPane().add(backgroundPanel);
            
            
            /**
             * Adiciona o painel principal com layout de grade, sendo uma coluna e quatro linhas
             */
            panel = new JPanel();
            panel.setOpaque(false);
            add(panel, BorderLayout.SOUTH);
            
            /**
             * Adiciona listeners para os botões do menu principal
             */
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /**
                     * Verifica qual o botão pressionado para chamar o método correspondente
                     */
                    try {
                        if (e.getSource() == resultadosBtn) {
                            controller.listarResultados();
                        } else if (e.getSource() == mesarioBtn) {
                            controller.abrirModuloMesario();
                        } else if (e.getSource() == votarBtn) {
                            controller.iniciarVotacao();
                        } else if (e.getSource() == sairBtn) {
                            System.exit(0);
                        }
                    } catch (Exception ex) {
                        MensagemDialogo.mostrarMensagemDialogo(ex);
                    }
                }
            };
            
            /**
             * Instanciando e definindo as propriedades de tamanho, posição e texto dos botões do menu principal, bem como adicionando os listeners
             */
            votarBtn = new JButton("Votar");
            votarBtn.setBounds(0, 0, 100, 30);
            votarBtn.addActionListener(listener);
            
            mesarioBtn = new JButton("Módulo Mesário");
            mesarioBtn.setBounds(0, 0, 100, 30);
            mesarioBtn.addActionListener(listener);
            
            resultadosBtn = new JButton("Resultado das Eleições");
            resultadosBtn.setBounds(0, 30, 100, 30);
            resultadosBtn.addActionListener(listener);
            
            sairBtn = new JButton("Sair");
            sairBtn.setBounds(0, 30, 100, 30);
            sairBtn.addActionListener(listener);
            
            /**
             * Adição dos botões ao painel principal e definindo a visisibilidade da janela
             */
            panel.add(votarBtn);
            panel.add(mesarioBtn);
            panel.add(resultadosBtn);
            panel.add(sairBtn);
            setVisible(true);
        }
    }

    /**
     * Reseta a variável de controle quando a janela é fechada
     */
    public void adicionarListenerJanelaFechando() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                janelaAberta = false;
            }
        });
    }
}