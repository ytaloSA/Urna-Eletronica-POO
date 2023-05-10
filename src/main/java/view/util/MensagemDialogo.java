package main.java.view.util;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class MensagemDialogo {
    private static boolean popupFechado = true;

    /**
     * Classe que exibe caixa de díalogo para exceções, mas verificando se já há uma janela sendo exibida
     * @param ex é a exception lançada e tratada em um bloco try-catch
     */
    public static void mostrarMensagemDialogo(Exception ex) {
        if (popupFechado) {
            popupFechado = false;
            JOptionPane.showMessageDialog(null,ex.getMessage());
            popupFechado = true;
        }
    }
}
