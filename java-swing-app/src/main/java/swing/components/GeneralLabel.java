package swing.components;

import javax.swing.*;
import java.awt.*;

public class GeneralLabel extends JLabel {

    public GeneralLabel(String text) {
        setText(text);
        setFont(new Font("Dialog", Font.BOLD, 16));
    }
}
