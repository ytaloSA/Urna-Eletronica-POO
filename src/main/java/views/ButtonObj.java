import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonObj {
    public String name;
    public String namePressed;
    public ImageIcon icon;
    public ImageIcon iconPressed;
    public JButton button;

    public ButtonObj(String nome, String caminho) {
        name = nome + ".jpg";
        namePressed = nome + "_down.jpg";
        icon = new ImageIcon(caminho + name);
        iconPressed = new ImageIcon(caminho + namePressed);
        button = new JButton(icon);
        button.setBorder(null);
    }

    public void setImageButton(boolean pressed) {
        if (pressed) {
            button.setIcon(iconPressed);
        } else {
            button.setIcon(icon);
        }
    }
}