package swing.components.panels;

import swing.SwingApp;

import javax.swing.*;

public class FirstPanel extends GeneralGroupPanel{

    public static final String[] OPTIONS = {"Option 1", "Option 2", "Option 3"};

    public FirstPanel() {
        super("First panel");
        var comboBox = new JComboBox<>(OPTIONS);

        comboBox.addItemListener(e -> {
            switch (comboBox.getSelectedIndex()) {
                case 0:
                    SwingApp.CurrentFirstValue = OPTIONS[0];
                    break;
                case 1:
                    SwingApp.CurrentFirstValue = OPTIONS[1];
                    break;
                case 2:
                    SwingApp.CurrentFirstValue = OPTIONS[2];
                    break;
            }
            SwingApp.updateCommand();
        });

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelComponent)
                .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                .addComponent(labelComponent)
                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
    }
}
