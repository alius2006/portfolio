package swing.components.panels;

import swing.SwingApp;

import javax.swing.*;

public class FourthPanel extends GeneralGroupPanel {

    public static final String[] OPTIONS = {"One option", "The other one option", "Another option"};

    public FourthPanel() {
        super("Fourth panel");

        var firstRadioButton = new JRadioButton(OPTIONS[0]);
        var secondGridRadioButton = new JRadioButton(OPTIONS[1]);
        var thirdRadioButton = new JRadioButton(OPTIONS[2]);
        firstRadioButton.setSelected(true);

        var buttonGroup = new ButtonGroup();
        buttonGroup.add(firstRadioButton);
        buttonGroup.add(secondGridRadioButton);
        buttonGroup.add(thirdRadioButton);

        firstRadioButton.addActionListener(e -> {
            SwingApp.CurrentFourthValue = OPTIONS[0];
            SwingApp.updateCommand();
        });

        secondGridRadioButton.addActionListener(e -> {
            SwingApp.CurrentFourthValue = OPTIONS[1];
            SwingApp.updateCommand();
        });

        thirdRadioButton.addActionListener(e -> {
            SwingApp.CurrentFourthValue = OPTIONS[2];
            SwingApp.updateCommand();
        });

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelComponent)
                                .addComponent(firstRadioButton)
                                .addComponent(secondGridRadioButton)
                                .addComponent(thirdRadioButton))
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(labelComponent)
                        .addComponent(firstRadioButton)
                        .addComponent(secondGridRadioButton)
                        .addComponent(thirdRadioButton)
        );
    }
}
