package main.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import main.java.view.util.MensagemDialogo;

public class MesarioView extends WindowView {
    private CardLayout cardLayout;
    private JPanel menu, panelBackground, panelPrincipal, panelCadastrarEleitor, panelAutorizarEleitor;
    private JPanel [] panelVazio = new JPanel[14];
    private JButton btnAutorizarEleitor,btnCadEleitor, btnResetEleicao, btnFecharPrincipal, btnVoltarCadEleitor, btnVoltarAutEleitor, btnEnviarEleitor;
    private JTextField nomeEleitor;
    private JLabel tituloPrincipal, tituloCadastroEleitor, tituloAutorizarEleitor;

    public MesarioView () {
        if (!janelaAberta) {
            setTitle("Urna Eletrônica: Módulo Mesário");
            setSize(500,500);
            setExtendedState(MAXIMIZED_BOTH);
            setLayout(new GridLayout(1,2));
            
            cardLayout = new CardLayout();
            panelBackground = new JPanel();
            panelBackground.setLayout(cardLayout);
            panelBackground.setSize(this.getWidth(), this.getHeight());
            menu = new JPanel();
            add(menu);
            add(panelBackground);
            
            panelPrincipal = new JPanel();
            panelPrincipal.setLayout(new BorderLayout());
            tituloPrincipal = new JLabel("Menu Mesário");
            tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
            panelPrincipal.add(tituloPrincipal, BorderLayout.CENTER);
            
            panelCadastrarEleitor = new JPanel();
            panelCadastrarEleitor.setSize(this.getWidth(), this.getHeight());
            tituloCadastroEleitor = new JLabel("Cadastrar Eleitor");
            panelCadastrarEleitor.add(tituloCadastroEleitor);
            
            panelAutorizarEleitor = new JPanel();
            panelAutorizarEleitor.setSize(this.getWidth(), this.getHeight());
            panelAutorizarEleitor.setLayout(new GridLayout(3, 1));
            tituloAutorizarEleitor = new JLabel("Autorizar Eleitor");
            panelAutorizarEleitor.add(tituloAutorizarEleitor);
            
            panelBackground.add(panelPrincipal, "panelPrincipal");
            panelBackground.add(panelCadastrarEleitor, "panelCadastrarEleitor");
            panelBackground.add(panelAutorizarEleitor, "panelAutorizarEleitor");
            mostrarPrincipal();

            btnAutorizarEleitor = new JButton("Autorizar Eleitor");
            btnAutorizarEleitor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarAutorizarEleitor();
                }
            });


            btnCadEleitor = new JButton("Cadastrar Eleitor");
            btnCadEleitor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        mostrarCadastroEleito();
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            });
            
            btnResetEleicao = new JButton("Reiniciar Eleição");
            btnResetEleicao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.reiniciarEleicao();
                }
            });

            btnFecharPrincipal = new JButton("Fechar Janela");
            btnFecharPrincipal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    janelaAberta = false;
                }
            });

            btnVoltarCadEleitor = new JButton("Cancelar");
            btnVoltarCadEleitor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPrincipal();
                }
            });

            btnVoltarAutEleitor = new JButton("Cancelar");
            btnVoltarAutEleitor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarPrincipal();
                }
            });

            menu.add(btnAutorizarEleitor);
            menu.add(btnCadEleitor);
            menu.add(btnResetEleicao);
            menu.add(btnFecharPrincipal);
            menu.setLayout(new GridLayout(4, 1));

            janelaAberta = true;
            setVisible(true);
        }

    }

    public void mostrarPrincipal() {
        cardLayout.show(panelBackground,"panelPrincipal");
    }
    
    public void mostrarCadastroEleito() throws ParseException {
        cardLayout.show(panelBackground,"panelCadastrarEleitor");
        nomeEleitor = new JTextField();
        nomeEleitor.setPreferredSize(new Dimension(200, 20));;
        panelCadastrarEleitor.add(nomeEleitor);
        btnEnviarEleitor = new JButton("Cadastrar");
        
        
        MaskFormatter mask = new MaskFormatter("##/##/####");
        JFormattedTextField formattedTextField = new JFormattedTextField(mask);
        panelCadastrarEleitor.add(formattedTextField);

        String dataInput = formattedTextField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        btnEnviarEleitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date data = dateFormat.parse(dataInput);
                    System.out.println("Data digitada: " + data);
                } catch (ParseException ex) {
                    MensagemDialogo.mostrarMensagemDialogo(new ParseException("Formato de data inválido. Digite a data no formato DD/MM/YYYY.", 0));
                }
                controller.inserirEleitor(nomeEleitor.getText());
            }
        });
        panelCadastrarEleitor.add(btnEnviarEleitor);
    }

    public void mostrarAutorizarEleitor() {
        cardLayout.show(panelBackground,"panelAutorizarEleitor");
    }
}
