package swing.components;

import swing.components.panels.FirstPanel;
import swing.components.panels.FourthPanel;
import swing.components.panels.SecondPanel;
import swing.components.panels.ThirdPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {

    public static CommandTextArea ActiveCommandTextArea = new CommandTextArea();

    public MainPanel() {

        setLayout(new GridBagLayout());
        setTitle("Swing app");
        var gridWidth = 2;

        add(new FirstPanel(), getGridBagConstraints(0, 0, 1, 1));
        add(new SecondPanel(), getGridBagConstraints(0, 1, 1, 1));
        add(new ThirdPanel(), getGridBagConstraints(1, 0, 1, 1));
        add(new FourthPanel(), getGridBagConstraints(1, 1, 1, 1));
        add(ActiveCommandTextArea, getGridBagConstraints(2, 0, gridWidth, 1));
        add(new ExecuteButton(), getGridBagConstraints(3, 0, gridWidth, 1));

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private GridBagConstraints getGridBagConstraints(int y, int x, int gridWidth, int gridHeight) {
        var padding = 3;
        var insets = new Insets(padding, padding, padding, padding);
        return new GridBagConstraints(x, y, gridWidth, gridHeight, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
    }
}
