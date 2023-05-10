package main.java.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class ButtonUrna extends JButton {
    protected String keyName;
    private String nameIcon;
    private String nameIconPressed;
    private ImageIcon icon;
    private ImageIcon iconPressed;
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

    public String getNameIcon() {
        return nameIcon;
    }

    public String getNameIconPressed() {
        return nameIconPressed;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public ImageIcon getIconPressed() {
        return iconPressed;
    }
}