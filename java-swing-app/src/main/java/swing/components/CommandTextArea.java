package swing.components;

import swing.SwingApp;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CommandTextArea extends JTextArea {
    public CommandTextArea() {
        this.setLineWrap(true);
        this.setRows(2);
        this.setText(SwingApp.CurrentCommand);
        this.setWrapStyleWord(true);

        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingApp.CurrentCommand = getOwnText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingApp.CurrentCommand = getOwnText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SwingApp.CurrentCommand = getOwnText();
            }
        });
    }

    public String getOwnText() {
        return this.getText();
    }
}
