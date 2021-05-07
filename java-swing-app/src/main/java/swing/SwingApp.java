package swing;

import swing.components.MainPanel;
import swing.components.panels.FirstPanel;
import swing.components.panels.FourthPanel;
import swing.components.panels.SecondPanel;
import swing.enums.MyEnum;
import java.util.Objects;

public class SwingApp {

    public static String CurrentFirstValue = FirstPanel.OPTIONS[0];
    public static String CurrentSecondValue = SecondPanel.OPTIONS[2];
    public static MyEnum CurrentThirdValue = MyEnum.NAME2;
    public static String CurrentFourthValue = FourthPanel.OPTIONS[0];
    public static String CurrentFifthValue = "defaultValue";
    public static String CurrentCommand = CurrentThirdValue.getValue() + " " + CurrentSecondValue + " " + CurrentFourthValue + " " + CurrentFirstValue;

    public static void main(String[] args) {
        new MainPanel();
    }

    public static void updateCommand() {
        String command = "";
        command += getFirstValue();
        command += " " + getSecondValue();
        if (Objects.equals(CurrentSecondValue, SecondPanel.OPTIONS[3])) command += " " + getFifthValue();
        command += " " + getThirdValue();
        command += " " + getFourthValue();
        CurrentCommand = command;
        MainPanel.ActiveCommandTextArea.setText(command);
    }

    private static String getFirstValue() {
        return CurrentFirstValue;
    }

    private static String getSecondValue() {
        return CurrentSecondValue;
    }

    public static String getThirdValue() {
        return CurrentThirdValue.getValue();
    }

    private static String getFourthValue() {
        return CurrentFourthValue;
    }

    private static String getFifthValue() {
        return CurrentFifthValue;
    }
}
