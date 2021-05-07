package swing.components.panels;

import swing.SwingApp;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SecondPanel extends GeneralGroupPanel {

    public static final String[] OPTIONS = {"First radio button", "Second radio button", "Third radio button", "Fourth radio button"};

    public SecondPanel() {
        super("Second panel");

        var firstRadioButton = new JRadioButton(OPTIONS[0]);
        var secondRadioButton = new JRadioButton(OPTIONS[1]);
        var thirdRadioButton = new JRadioButton(OPTIONS[2]);
        var fourthRadioButton = new JRadioButton(OPTIONS[3]);
        thirdRadioButton.setSelected(true);

        var textField = new JTextField(SwingApp.CurrentFifthValue);
        textField.setEditable(false);

        var buttonGroup = new ButtonGroup();
        buttonGroup.add(firstRadioButton);
        buttonGroup.add(secondRadioButton);
        buttonGroup.add(thirdRadioButton);
        buttonGroup.add(fourthRadioButton);

        firstRadioButton.addActionListener(e -> {
            SwingApp.CurrentSecondValue = OPTIONS[0];
            textField.setEditable(false);
            SwingApp.updateCommand();
        });

        secondRadioButton.addActionListener(e -> {
            SwingApp.CurrentSecondValue = OPTIONS[1];
            textField.setEditable(false);
            SwingApp.updateCommand();
        });

        thirdRadioButton.addActionListener(e -> {
            SwingApp.CurrentSecondValue = OPTIONS[2];
            textField.setEditable(false);
            SwingApp.updateCommand();
        });

        fourthRadioButton.addActionListener(e -> {
            SwingApp.CurrentSecondValue = OPTIONS[3];
            textField.setEditable(true);
            SwingApp.updateCommand();
        });

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingApp.CurrentFifthValue = textField.getText();
                SwingApp.updateCommand();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingApp.CurrentFifthValue = textField.getText();
                SwingApp.updateCommand();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SwingApp.CurrentFifthValue = textField.getText();
                SwingApp.updateCommand();
            }
        });

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(labelComponent)
                                .addComponent(firstRadioButton)
                                .addComponent(secondRadioButton)
                                .addComponent(thirdRadioButton)
                                .addComponent(fourthRadioButton))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(labelComponent)
                        .addComponent(firstRadioButton)
                        .addComponent(secondRadioButton)
                        .addComponent(thirdRadioButton)
                        .addComponent(fourthRadioButton)
        );
    }
}
