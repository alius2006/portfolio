package swing.components.panels;

import swing.SwingApp;
import swing.enums.MyEnum;

import javax.swing.*;
import java.util.Objects;

public class ThirdPanel extends GeneralGroupPanel{

    public ThirdPanel() {
        super("Third panel");
        
        var values = MyEnum.values();
        String[] options = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            options[i] = values[i].getValue();
        }

        var comboBox = new JComboBox<>(options);
        comboBox.setSelectedItem(MyEnum.NAME2.getValue());

        comboBox.addItemListener(e -> {
            SwingApp.CurrentThirdValue = MyEnum.fromValue(Objects.requireNonNull(
                    comboBox.getSelectedItem()).toString());
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
