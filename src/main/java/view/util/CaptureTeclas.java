package main.java.view.util;

import java.awt.KeyEventDispatcher;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import main.java.view.ButtonUrna;
import java.awt.event.*;

public class CaptureTeclas implements KeyEventDispatcher {
    private ButtonUrna [] buttons;

    public CaptureTeclas(ButtonUrna [] bs) {
        buttons = bs;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        Character [] chars = {'0','1','2','3','4','5','6','7','8','9'};
        List<Character> listaChar = new ArrayList<Character>(Arrays.asList(chars));
        
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            
            //System.out.println(KeyEvent.getKeyText(e.getKeyCode()) + ": " + e.getKeyCode());
            
            char tecla = e.getKeyChar();
            int enter = 10, backspace = 8, space = 32;
            
            if (listaChar.contains(tecla)) {
                int index = Character.getNumericValue(tecla);
                gerarEventoClick(index);
            } else if (e.getKeyCode() == space) {
                gerarEventoClick(10);
            } else if (e.getKeyCode() == backspace) {
                gerarEventoClick(11);
            } else if (e.getKeyCode() == enter) {
                gerarEventoClick(12);
            } else {
                if (e.getKeyCode() >= 48 && e.getKeyCode()  <= 111 || e.getKeyCode() == 44 || e.getKeyCode() == 46 || e.getKeyCode() == 131 || e.getKeyCode() == 129 || e.getKeyCode() > 192 && e.getKeyCode() != 524) {
                    try {
                        throw new UnsupportedOperationException("Use somente números.");
                    } catch (Exception ex) {
                        MensagemDialogo.mostrarMensagemDialogo(ex);
                    }
                }
            }
        }
        return false;
    }
    
    private void gerarEventoClick(int index) {
        Component comp = buttons[index];
        MouseEvent eventoClick = new MouseEvent(comp, MouseEvent.MOUSE_PRESSED, 1000, MouseEvent.BUTTON1_DOWN_MASK,0,0,1,false);
        comp.dispatchEvent(eventoClick);
    }
}
