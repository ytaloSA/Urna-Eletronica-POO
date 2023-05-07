package main.java.view;

import javax.swing.*;
import main.java.controllers.*;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * Classe responsável por gerar a tela do menu principal da aplicação.
 */
public class MenuPrincipalView extends JFrame {
    private UrnaController controller;
    private JPanel panel;
    private JButton votarBtn, mesarioBtn, resultadosBtn, sairBtn;

    public MenuPrincipalView(UrnaController controller) {
        this.controller = controller;

        setSize(500,500);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,1,1));
        add(panel);

        /**
         * Adiciona listeners para os botões do menu principal
         */
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    if (e.getSource() == resultadosBtn) {
                        controller.listarResultados();
                    } else if (e.getSource() == mesarioBtn) {
                        controller.carregarModuloMesario();
                    } else if (e.getSource() == votarBtn) {
                        controller.iniciarVotacao();
                    } else if (e.getSource() == sairBtn) {
                        System.exit(0);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        };
        
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

        panel.add(votarBtn);
        panel.add(mesarioBtn);
        panel.add(resultadosBtn);
        panel.add(sairBtn);
        setVisible(true);
    }
}