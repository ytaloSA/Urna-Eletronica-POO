import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class MenuPrincipalView extends JFrame {
    public MenuPrincipalView() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        add(panel3);
        
        JButton mesarioBtn = new JButton("Módulo Mesário");
        panel1.add(mesarioBtn, BorderLayout.CENTER);
        mesarioBtn.setBounds(0, 0, 100, 30);

        JButton resultadosBtn = new JButton("Resultado das Eleições");
        panel1.add(resultadosBtn,BorderLayout.NORTH);
        resultadosBtn.setBounds(0, 30, 100, 30);
        
        JButton sairBtn = new JButton("Sair");
        panel1.add(sairBtn, BorderLayout.SOUTH);
        sairBtn.setBounds(0, 30, 100, 30);

        ActionListener meuOuvinte = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão foi clicado!");
            }
        };

        mesarioBtn.addActionListener(meuOuvinte);
        resultadosBtn.addActionListener(meuOuvinte);
        sairBtn.addActionListener(meuOuvinte);
    }
}