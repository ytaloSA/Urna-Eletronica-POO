package main;
import main.java.models.*;
/**Para compilar ṕe necessário estar na pasta src e executar:
javac main.Main.java
Para executar, também é necessário estar na pasta src e usar o mesmo formato:
java main.Main
Pode ser main/Main.java ou main.Main que funciona igualmente**/
public class Main {
    public static void main(String[] args) {
        Candidato Maria = new Candidato("Maria", 50);
        System.out.println(Maria.nome);
    }
}
