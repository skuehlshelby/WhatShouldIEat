package view;

import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {
    private static final String freshStartPanelName = "Fresh Start Panel";
    private static final String cardDisplayPanelName = "Card Display Panel";

    private final IFreshStartPanel freshStartPanel;
    private final ICardDisplayPanel cardDisplayPanel;
    private final CardLayout layout;

    public DataPanel() {
        layout = new CardLayout();
        freshStartPanel = new FreshStartPanel();
        cardDisplayPanel = new CardDisplayPanel();

        setLayout(layout);
        add((Container) freshStartPanel, freshStartPanelName);
        add((Container) cardDisplayPanel, cardDisplayPanelName);
    }

    public void showFreshStartPanel()
    {
        layout.show((Container) cardDisplayPanel, cardDisplayPanelName);
    }

    public void showCardDisplayPanel()
    {
        layout.show((Container) cardDisplayPanel, cardDisplayPanelName);
    }
}
