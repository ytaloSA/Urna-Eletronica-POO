package main.java.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class ButtonUrna extends JButton {
    public String keyName;
    public String nameIcon;
    public String nameIconPressed;
    public ImageIcon icon;
    public ImageIcon iconPressed;

    public ButtonUrna(String nome, String caminho) {
        super();
        nameIcon = nome + ".jpg";
        nameIconPressed = nome + "_down.jpg";
        icon = new ImageIcon(caminho + nameIcon);
        iconPressed = new ImageIcon(caminho + nameIconPressed);
        setIcon(icon);
        setBorder(null);
    }

    public String getKeyName() {
        return keyName;
    }

    public void setImageButton(boolean pressed) {
        if (pressed) {
            setIcon(iconPressed);
        } else {
            setIcon(icon);
        }
    }
}