package main.urnaeletronica.controle;

import java.text.ParseException;
import java.util.ArrayList;

import main.urnaeletronica.modelos.Arquivos;
import main.urnaeletronica.modelos.Candidato;
import main.urnaeletronica.modelos.Resultado;
import main.urnaeletronica.modelos.Voto;
import main.urnaeletronica.visual.*;

public class UrnaController implements iUrnaController {
    private UrnaEletronicaView telaUrna;
    private ResultadosView telaResultados;
    private MesarioView telaMesario;
    private String numeroDigitado;
    
    public UrnaController () {}
    
    public void iniciarVotacao() {
        telaUrna = new UrnaEletronicaView();
    }
    
    @Override
    public void listarResultados() {
        telaResultados = new ResultadosView();
    }

    @Override
    public void abrirModuloMesario() {
        try {
            telaMesario = new MesarioView();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void carregarListaCandidatos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarListaCandidatos'");
    }

    @Override
    public void carregarListaEleitores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarListaEleitores'");
    }

    @Override
    public void carregarEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'carregarEleicao'");
    }


    @Override
    public ArrayList<Resultado> carregarResultados() {
        ArrayList<Resultado> resultados = new ArrayList<Resultado>();
        try {
            ArrayList<Candidato> candidatos = Arquivos.getCandidatos();
            if (candidatos.size() == 0) {
                throw new ArrayIndexOutOfBoundsException("Arquivo de candidatos está vazio.");
            }
            ArrayList<Voto> votos = Arquivos.getVotos();
            if (votos.size() > 0) {
                for (Candidato candidato : candidatos) {
                    Resultado resultado = new Resultado(candidato, votos);
                    resultados.add(resultado);
                }
            } else {
                throw new ArrayIndexOutOfBoundsException("Arquivo de votos está vazio.");
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.getMessage());
        }
        return resultados;
    }

    @Override
    public void reiniciarEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reiniciarEleicao'");
    }

    @Override
    public void encerrarEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encerrarEleicao'");
    }

    @Override
    public void autorizarEleitor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'autorizarEleitor'");
    }

    @Override
    public void inserirCandidato() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirCandidato'");
    }

    @Override
    public void inserirEleitor(String nome, String nascimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirEleitor'");
    }

    @Override
    public void inserirEleicao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirEleicao'");
    }

    @Override
    public void validarEleitor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarEleitor'");
    }

    @Override
    public void registrarVoto(String voto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarVoto'");
    }
}