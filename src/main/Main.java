package main;

import main.java.controllers.*;
import main.java.models.Arquivos;
import main.java.models.*;
import main.java.view.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**Para compilar é necessário estar na pasta src e executar:
javac main.Main.java
Para executar, também é necessário estar na pasta src e usar o mesmo formato:
java main.Main
Pode ser main/Main.java ou main.Main que funciona igualmente
O trecho abaixo imprime separadamente cada um dos elementos
Serve apenas para entender a sintaxe dos candidatos
**/
public final class Main implements iMain,iArquivos {
    public static void main(String[] args) {
        for (String[] linha : iArquivos.lerArquivo("candidatos.txt")){
            for (String dado:linha){
                System.out.println(dado);
            }
        }
        for (String[] linha : Arquivos.lerTxt("votos.txt")){
            for (String dado:linha){
                System.out.println(dado);
            }
        }
        String diretorioTrabalho = System.getProperty("user.dir");
        System.out.println(diretorioTrabalho);

        try {
            UrnaController controller = new UrnaController();
            MenuPrincipalView MenuPrincipal = new MenuPrincipalView(controller);
            MenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        //Candidato objeto = new Candidato();
        //ArrayList<Candidato> lista = ((ArrayList<Candidato>)objeto.obterCandidatosGenericos());
        //for (Candidato candidato:lista){
            //System.out.println(candidato.titulo);
            //System.out.println(candidato.dados);
        //}
    }
}
