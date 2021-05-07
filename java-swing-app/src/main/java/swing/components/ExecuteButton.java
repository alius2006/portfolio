package swing.components;

import swing.SwingApp;

import javax.swing.*;

public class ExecuteButton extends JButton {

    public ExecuteButton() {
        this.setText("Execute");
        this.addActionListener(e -> execute());
    }

    private void execute() {
        JOptionPane.showMessageDialog(null, "Alert message!");

        var command = "cmd /c start " + SwingApp.CurrentCommand;
        System.out.println("Executing: " + command);

        /*
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
