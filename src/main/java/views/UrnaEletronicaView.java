import javax.swing.*;

import java.awt.Color;
import java.awt.Image;

public class UrnaEletronicaView extends JFrame {
    private ButtonObj [] buttons = new ButtonObj[13];
    private ImageIcon itela, itopo, ifaixaDir, iladoEsqTec, iladoDirTec, iptaBaixo7, iptaBaixo9, iabaixoTec;
    private JLabel jLtela, jLtopo, jLfaixaDir, jLladoEsqTec, jLladoDirTec, jLptaBaixo7, jLptaBaixo9, jLabaixoTec;
    private JPanel panel;

    public UrnaEletronicaView () {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        String caminhoUser = System.getProperty("user.dir");
        String caminhoImages = caminhoUser + "\\src\\main\\resources\\urna\\images\\";

        for (int c = 0; c <= 9; c++) {
            buttons[c] = new ButtonObj("n" + c, caminhoImages);
        }

        buttons[10] = new ButtonObj("branco", caminhoImages);
        buttons[11] = new ButtonObj("corrige", caminhoImages);
        buttons[12] = new ButtonObj("confirma", caminhoImages);

        for (int c = 0; c < 13; c++) {
            panel.add(buttons[c].button);
        }

        itela = new ImageIcon(caminhoImages + "tela.jpg");
        itopo = new ImageIcon(caminhoImages + "topo.jpg");
        ifaixaDir = new ImageIcon(caminhoImages + "faixaDir.jpg");
        iladoEsqTec = new ImageIcon(caminhoImages + "ladoEsqTec.jpg");
        iladoDirTec = new ImageIcon(caminhoImages + "ladoDirTec.jpg");
        iptaBaixo7 = new ImageIcon(caminhoImages + "ptaBaixo7.jpg");
        iptaBaixo9 = new ImageIcon(caminhoImages + "ptaBaixo9.jpg");
        iabaixoTec = new ImageIcon(caminhoImages + "abaixoTec.jpg");
        
        jLtela = new JLabel(itela);
        jLtopo = new JLabel(itopo);
        jLfaixaDir = new JLabel(ifaixaDir);
        jLladoEsqTec = new JLabel(iladoEsqTec);
        jLladoDirTec = new JLabel(iladoDirTec);
        jLptaBaixo7 = new JLabel(iptaBaixo7);
        jLptaBaixo9 = new JLabel(iptaBaixo9);
        jLabaixoTec = new JLabel(iabaixoTec);

        panel.add(jLtela);
        panel.add(jLtopo);
        panel.add(jLfaixaDir);
        panel.add(jLladoEsqTec);
        panel.add(jLladoDirTec);
        panel.add(jLptaBaixo7);
        panel.add(jLptaBaixo9);
        panel.add(jLabaixoTec);

        jLtela.setBounds(0, 0, itela.getIconWidth(), itela.getIconHeight());

        jLtopo.setBounds(itela.getIconWidth(), -3, itopo.getIconWidth(), itopo.getIconHeight());

        jLfaixaDir.setBounds(itela.getIconWidth() + itopo.getIconWidth(), 32,ifaixaDir.getIconWidth(),ifaixaDir.getIconHeight());

        jLladoEsqTec.setBounds(itela.getIconWidth(), itopo.getIconHeight()-3, iladoEsqTec.getIconWidth(), iladoEsqTec.getIconHeight());

        buttons[1].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3, buttons[1].icon.getIconWidth(), buttons[1].icon.getIconHeight());

        buttons[2].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[1].icon.getIconWidth(), itopo.getIconHeight()-3, buttons[2].icon.getIconWidth(), buttons[2].icon.getIconHeight());

        buttons[3].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[1].icon.getIconWidth() + buttons[2].icon.getIconWidth(), itopo.getIconHeight()-3, buttons[3].icon.getIconWidth(), buttons[3].icon.getIconHeight());

        jLladoDirTec.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[1].icon.getIconWidth() + buttons[2].icon.getIconWidth() + buttons[3].icon.getIconWidth(), itopo.getIconHeight()-3, iladoDirTec.getIconWidth(), iladoDirTec.getIconHeight());

        buttons[4].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight(), buttons[4].icon.getIconWidth(), buttons[4].icon.getIconHeight());

        buttons[5].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[4].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight(), buttons[5].icon.getIconWidth(), buttons[5].icon.getIconHeight());

        buttons[6].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[5].icon.getIconWidth() + buttons[4].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight(), buttons[6].icon.getIconWidth(), buttons[6].icon.getIconHeight());

        buttons[7].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight(), buttons[7].icon.getIconWidth(), buttons[7].icon.getIconHeight());

        buttons[8].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[4].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight(), buttons[8].icon.getIconWidth(), buttons[8].icon.getIconHeight());

        buttons[9].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + buttons[4].icon.getIconWidth() + buttons[5].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight(), buttons[9].icon.getIconWidth(), buttons[9].icon.getIconHeight());
        
        jLptaBaixo7.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[9].icon.getIconHeight(), iptaBaixo7.getIconWidth(), iptaBaixo7.getIconHeight());
        
        buttons[0].button.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + iptaBaixo7.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[9].icon.getIconHeight(), buttons[0].icon.getIconWidth(), buttons[0].icon.getIconHeight());
        
        jLptaBaixo9.setBounds(itela.getIconWidth() + iladoEsqTec.getIconWidth() + iptaBaixo7.getIconWidth() + buttons[0].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[9].icon.getIconHeight(), iptaBaixo9.getIconWidth(), iptaBaixo9.getIconHeight());

        buttons[10].button.setBounds(itela.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo7.getIconHeight(), buttons[10].icon.getIconWidth(), buttons[10].icon.getIconHeight());
    
        buttons[11].button.setBounds(itela.getIconWidth() + buttons[10].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo7.getIconHeight(), buttons[11].icon.getIconWidth(), buttons[11].icon.getIconHeight());
    
        buttons[12].button.setBounds(itela.getIconWidth() + buttons[10].icon.getIconWidth() + buttons[11].icon.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo9.getIconHeight(), buttons[12].icon.getIconWidth(), buttons[12].icon.getIconHeight());

        jLabaixoTec.setBounds(itela.getIconWidth(), itopo.getIconHeight()-3 + buttons[1].icon.getIconHeight() + buttons[4].icon.getIconHeight() + buttons[7].icon.getIconHeight() + iptaBaixo7.getIconHeight() + buttons[10].icon.getIconHeight(), iabaixoTec.getIconWidth(), iabaixoTec.getIconHeight());
    }
}