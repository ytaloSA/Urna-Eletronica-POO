package main.java.views;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class MenuPrincipalView extends JFrame {

    private JPanel panel;
    private JButton votarBtn, mesarioBtn, resultadosBtn, sairBtn;

    public MenuPrincipalView() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,1,1));
        add(panel);
        
        votarBtn = new JButton("Votar");
        panel.add(votarBtn);
        votarBtn.setBounds(0, 0, 100, 30);

        mesarioBtn = new JButton("Módulo Mesário");
        panel.add(mesarioBtn);
        mesarioBtn.setBounds(0, 0, 100, 30);

        resultadosBtn = new JButton("Resultado das Eleições");
        panel.add(resultadosBtn);
        resultadosBtn.setBounds(0, 30, 100, 30);
        
        sairBtn = new JButton("Sair");
        panel.add(sairBtn);
        sairBtn.setBounds(0, 30, 100, 30);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão foi clicado!");
            }
        };

        votarBtn.addActionListener(listener);
        mesarioBtn.addActionListener(listener);
        mesarioBtn.addActionListener(listener);
        resultadosBtn.addActionListener(listener);
        sairBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}