package view;

import java.awt.event.ActionListener;

public interface IButtonPanel {
    void addButtonPanelListener(IButtonPanelListener listener);

    void removeButtonPanelListener(IButtonPanelListener listener);
}
