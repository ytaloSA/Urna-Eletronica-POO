package main.urnaeletronica.visual;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

import main.urnaeletronica.modelos.Resultado;
import main.urnaeletronica.visual.util.MensagemDialogo;

public class ResultadosView extends WindowView {
    ArrayList<JLabel> jlResultados;
    JLabel jlTituloEleicao;
    ArrayList<Resultado> resultados;

    public ResultadosView() {
        super();
        constructResultadosView("Bolacha x Biscoito");
    }
    
    public ResultadosView(String titulo) {
        super();
        constructResultadosView("Bolacha x Biscoito");
    }

    public void constructResultadosView(String titulo) {
        
        if (!janelaAberta) {
            try {
                resultados = controller.carregarResultados();
            } catch (Exception e) {
                MensagemDialogo.mostrarMensagemDialogo(e);
            }
            jlTituloEleicao = new JLabel(titulo);
            add(jlTituloEleicao);
            setLayout(new GridLayout(resultados.size()+1,1));
            generatePanelResultados(resultados);
            janelaAberta = true;
        }
    }
    
    public void generatePanelResultados(ArrayList<Resultado> resultados) {
        for (Resultado resultado : resultados) {
            JLabel jl = new JLabel();
            jl.setText(resultado.getCandidato()+": "+resultado.getVotosContagem());
            jlResultados.add(jl);
            add(jl);
        }
    }
}
