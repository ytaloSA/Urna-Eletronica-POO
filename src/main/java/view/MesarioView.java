package main.java.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import main.java.view.util.MensagemDialogo;

public class MesarioView extends WindowView {
    private CardLayout cardLayout;
    private JPanel menu, panelBackground, panelPrincipal, panelCadastrarEleitor, panelAutorizarEleitor, panelReiniciarEleicao;
    private JButton btnAutorizarEleitor,btnCadEleitor, btnResetEleicao, btnFecharPrincipal, btnVoltarCadEleitor, btnVoltarAutEleitor, btnEnviarEleitor, btnReinicarEleicao;
    private JTextField nomeEleitor;
    private JLabel tituloPrincipal, tituloCadastroEleitor, tituloAutorizarEleitor, tituloReiniciarEleicao;

    public ArrayList<String[]> eleitoresFake() {
        ArrayList<String[]> eleitores = new ArrayList<String[]>();
        String [] str1 = {"#32587", "YURI DIAS PEREIRA GOMES", "11/11/1996"};
        String [] str2 = {"#32587", "YTALO SANTOS ARAGAO", "00/00/0000"};
        String [] str3 = {"#32587", "KALIL ARAUJO BISPO", "00/00/0000"};
        String [] str4 = {"#32587", "LUCAS ARAGAO DAMACENO", "00/00/0000"};
        String [] str5 = {"#32587", "GABRIEL ARGOLO JULIAO", "00/00/0000"};
        String [] str6 = {"#32587", "PEDRO AFONSO TAVARES", "00/00/0000"};
        String [] str7 = {"#32587", "GYANNINE CANDEIAS GOMES", "00/00/0000"};
        String [] str8 = {"#32587", "LETICIA CAVALCANTI", "00/00/0000"};
        String [] str9 = {"#32587", "LUCCA COSTA LEANDRO", "00/00/0000"};
        String [] str10 = {"#32587", "DOUGLAS CUNHA DE JESUS", "00/00/0000"};
        eleitores.add(str1);
        eleitores.add(str2);
        eleitores.add(str3);
        eleitores.add(str4);
        eleitores.add(str5);
        eleitores.add(str6);
        eleitores.add(str7);
        eleitores.add(str8);
        eleitores.add(str9);
        eleitores.add(str10);

        return eleitores;
    }

    public MesarioView () throws ParseException {
        if (!janelaAberta) {
            setTitle("Urna Eletrônica: Módulo Mesário");
            setSize(500,500);
            setExtendedState(MAXIMIZED_BOTH);
            setLayout(new GridLayout(1,2));
            
            cardLayout = new CardLayout();
            panelBackground = new JPanel();
            panelBackground.setLayout(cardLayout);
            panelBackground.setSize(this.getWidth()/2, this.getHeight());
            menu = new JPanel();
            add(menu);
            add(panelBackground);
            
            panelPrincipal = new JPanel();    
            tituloPrincipal = new JLabel("Menu Mesário");
            setTamanhoFontText(tituloPrincipal, 30f);
            
            panelPrincipal.setLayout(new BorderLayout());
            tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
            panelPrincipal.add(tituloPrincipal, BorderLayout.CENTER);
            
            panelAutorizarEleitor = new JPanel();
            panelAutorizarEleitor.setSize(panelBackground.getWidth(), panelBackground.getHeight());
            panelAutorizarEleitor.setLayout(new BorderLayout());

            ArrayList<String[]> eleitores = eleitoresFake();
            
            JPanel listaPanels = new JPanel();
            listaPanels.setLayout(new GridLayout(eleitores.size(),2));
            
            Boolean style = true, votou = false, autorizado = false;

            for (String [] eleitor : eleitores) {
                gerarListaEleitores(listaPanels, eleitor[0], eleitor[1], eleitor[2], style, autorizado, votou);
                style = !style;
            }
            
            JScrollPane containerScroll = new JScrollPane(listaPanels);
            containerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            containerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            JPanel panelTitulo = new JPanel();
            panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 50, 50, 50));
            tituloAutorizarEleitor = new JLabel("Autorizar Eleitor");
            setTamanhoFontText(tituloAutorizarEleitor, 10f);
            panelTitulo.add(tituloAutorizarEleitor);
            tituloAutorizarEleitor.setHorizontalAlignment(SwingConstants.CENTER);
            panelAutorizarEleitor.add(panelTitulo, BorderLayout.NORTH);
            panelAutorizarEleitor.add(containerScroll, BorderLayout.CENTER);

            panelCadastrarEleitor = new JPanel();
            panelCadastrarEleitor.setLayout(new GridLayout(4,1));
            panelCadastrarEleitor.setSize(panelBackground.getWidth(), panelBackground.getHeight());

            GridBagLayout gridBagLayout = new GridBagLayout();
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(0, 0, 10, 0);
            
            tituloCadastroEleitor = new JLabel("Cadastrar Eleitor");
            setTamanhoFontText(tituloCadastroEleitor, 10f);
            tituloCadastroEleitor.setHorizontalAlignment(SwingConstants.CENTER);
            panelCadastrarEleitor.add(tituloCadastroEleitor);

            JPanel containerInputs = new JPanel();
            containerInputs.setLayout(gridBagLayout);
            containerInputs.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 50, 0, 50));

            JLabel nome = new JLabel("Nome:");
            nome.setHorizontalAlignment(SwingConstants.CENTER);
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.weightx = 0.5;
            containerInputs.add(nome, constraints);

            constraints.gridwidth = GridBagConstraints.REMAINDER;
            nomeEleitor = new JTextField();
            nomeEleitor.setPreferredSize(new Dimension(200, 20));;
            nomeEleitor.setHorizontalAlignment(SwingConstants.CENTER);
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            constraints.weightx = 1.0;
            containerInputs.add(nomeEleitor, constraints);

            JLabel nascimento = new JLabel("Data de Nascimento:");
            nascimento.setHorizontalAlignment(SwingConstants.CENTER);
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            constraints.weightx = 0.5;
            containerInputs.add(nascimento, constraints);

            MaskFormatter mask = new MaskFormatter("##/##/####");
            JFormattedTextField nascimentoEleitor = new JFormattedTextField(mask);
            nascimentoEleitor.setHorizontalAlignment(SwingConstants.CENTER);
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.gridwidth = 2;
            constraints.weightx = 1.0;
            containerInputs.add(nascimentoEleitor, constraints);

            panelCadastrarEleitor.add(containerInputs);
            
            String dataInput = nascimentoEleitor.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            JPanel containerBtnEnviarEleitor = new JPanel();
            containerBtnEnviarEleitor.setLayout(new GridLayout(1,1));
            containerBtnEnviarEleitor.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 50, 50, 50));
            btnEnviarEleitor = new JButton("Cadastrar");
            btnEnviarEleitor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Date data = dateFormat.parse(dataInput);
                        System.out.println("Data digitada: " + data);
                    } catch (ParseException ex) {
                        MensagemDialogo.mostrarMensagemDialogo(new ParseException("Formato de data inválido. Digite a data no formato DD/MM/YYYY.", 0));
                    }
                    enviarCadastroEleitor(nomeEleitor.getText(), nascimentoEleitor.getText());
                }
            });
            containerBtnEnviarEleitor.add(btnEnviarEleitor);
            panelCadastrarEleitor.add(containerBtnEnviarEleitor);
            
            panelReiniciarEleicao = new JPanel();
            panelReiniciarEleicao.setLayout(new GridLayout(2,1));
            JPanel containerTituloReiniciarEleicao = new JPanel();
            containerTituloReiniciarEleicao.setLayout(new BorderLayout());
            JPanel containerBtnReiniciarEleicao = new JPanel();
            containerBtnReiniciarEleicao.setLayout(new BorderLayout());
            containerBtnReiniciarEleicao.setBorder(javax.swing.BorderFactory.createEmptyBorder(150, 50, 150, 50));
            tituloReiniciarEleicao = new JLabel("Deseja realmente zerar os votos da eleição?");
            setTamanhoFontText(tituloReiniciarEleicao, 10f);
            tituloReiniciarEleicao.setHorizontalAlignment(SwingConstants.CENTER);
            btnReinicarEleicao = new JButton("Confimar");
            containerTituloReiniciarEleicao.add(tituloReiniciarEleicao, BorderLayout.CENTER);
            containerBtnReiniciarEleicao.add(btnReinicarEleicao, BorderLayout.CENTER);
            panelReiniciarEleicao.add(containerTituloReiniciarEleicao);
            panelReiniciarEleicao.add(containerBtnReiniciarEleicao);
            
            
            panelBackground.add(panelPrincipal, "panelPrincipal");
            panelBackground.add(panelCadastrarEleitor, "panelCadastrarEleitor");
            panelBackground.add(panelAutorizarEleitor, "panelAutorizarEleitor");
            panelBackground.add(panelReiniciarEleicao, "panelReiniciarEleicao");
            
            
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
                    mostrarCadastroEleito();
                }
            });
            
            btnResetEleicao = new JButton("Reiniciar Eleição");
            btnResetEleicao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarReiniciarEleicao();
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
    
    public void mostrarAutorizarEleitor() {
        cardLayout.show(panelBackground,"panelAutorizarEleitor");
    }

    public void mostrarCadastroEleito() {
        cardLayout.show(panelBackground,"panelCadastrarEleitor");
    }

    public void mostrarReiniciarEleicao() {
        cardLayout.show(panelBackground, "panelReiniciarEleicao");
    }

    public void gerarListaEleitores(JPanel listaPanels, String id, String nome, String nascimento, Boolean style, Boolean autorizado, Boolean votou) {
        JLabel idEleitor = new JLabel(id);
        idEleitor.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel nomeEleitor = new JLabel(nome);
        JLabel nascimentoEleitor = new JLabel(nascimento);
        nascimentoEleitor.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panelEleitor = new JPanel();
        panelEleitor.setLayout(new GridLayout(1,4));
        panelEleitor.add(idEleitor);
        panelEleitor.add(nomeEleitor);
        panelEleitor.add(nascimentoEleitor);

        if (!autorizado && !votou) {
            JButton btn = new JButton("Autorizar");
            panelEleitor.add(btn);
        } else if (autorizado && !votou) {
            JButton btn = new JButton("Desautorizar");
            panelEleitor.add(btn);
        } else {
            JLabel jaVotou = new JLabel("Votou");
            jaVotou.setHorizontalAlignment(SwingConstants.CENTER);
            panelEleitor.add(jaVotou);
        }

        listaPanels.add(panelEleitor);
        if (style) {
            panelEleitor.setBackground(Color.LIGHT_GRAY);
        }
    }

    private void enviarCadastroEleitor(String nome, String nascimento) {
        controller.inserirEleitor(nome, nascimento);
    }

    private void setTamanhoFontText(Component componente, Float tamanho) {
        Font font = componente.getFont();
        Font fontGrande = font.deriveFont(font.getSize() + tamanho);
        componente.setFont(fontGrande);
    }
}
