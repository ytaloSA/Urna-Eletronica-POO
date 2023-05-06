package main;
import main.java.models.*;
import main.java.controllers.*;
import main.java.views.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
/**Para compilar é necessário estar na pasta src e executar:
javac main.Main.java
Para executar, também é necessário estar na pasta src e usar o mesmo formato:
java main.Main
Pode ser main/Main.java ou main.Main que funciona igualmente
O trecho abaixo imprime separadamente cada um dos elementos
Serve apenas para entender a sintaxe dos candidatos
**/
public class Main {
    public static void main(String[] args) {
        System.setProperty("sun.java.command", "urnaeletronica");
        String processo = ManagementFactory.getRuntimeMXBean().getName();
        if (processo.contains("urnaeletronica")){
            System.exit(0);
        }
        while (true){
            System.out.println("Executando");
        }
    }
}
