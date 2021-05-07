package swing.components.panels;

import swing.components.GeneralLabel;

import javax.swing.*;
import java.awt.*;

public class GeneralGroupPanel extends JPanel {

    protected GroupLayout groupLayout;
    protected GeneralLabel labelComponent;

    public GeneralGroupPanel(String label) {
        groupLayout = new GroupLayout(this);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        labelComponent = new GeneralLabel(label);

        setLayout(groupLayout);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
