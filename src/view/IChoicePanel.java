package view;

import java.awt.event.ActionListener;

/**
 * @author Scott Kuehl-Shelby
 */
public interface IChoicePanel {
    void setChoice(String choice);

    void addChooseAgainActionListener(ActionListener listener);

    void removeChooseAgainActionListener(ActionListener listener);
}
