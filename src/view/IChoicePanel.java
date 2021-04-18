package view;

import java.awt.event.ActionListener;

public interface IChoicePanel {
    void setChoice(String choice);

    void addChooseAgainActionListener(ActionListener listener);

    void removeChooseAgainActionListener(ActionListener listener);
}
