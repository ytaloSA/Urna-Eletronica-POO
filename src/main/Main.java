package main;
import main.java.controllers.*;
import main.java.models.Arquivos;
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

    }
}
