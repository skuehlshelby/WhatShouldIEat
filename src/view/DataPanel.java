package view;

import view.freshStartPanel.FreshStartPanel;
import view.freshStartPanel.IFreshStartPanel;
import javax.swing.*;
import java.awt.*;

/**
 * @author Scott Kuehl-Shelby
 */
public class DataPanel extends JPanel implements IDataPanel {
    private static final String freshStartPanelName = "Fresh Start Panel";
    private static final String cardDisplayPanelName = "Card Display Panel";

    private final FreshStartPanel freshStartPanel;
    private final CardDisplayPanel cardDisplayPanel;

    public DataPanel() {
        freshStartPanel = new FreshStartPanel();
        cardDisplayPanel = new CardDisplayPanel();

        setLayout(new CardLayout());
        setBorder(BorderFactory.createTitledBorder("My favorites..."));
        add(freshStartPanel, freshStartPanelName);
        add(cardDisplayPanel, cardDisplayPanelName);
    }

    @Override
    public void showFreshStartPanel() {
        CardLayout c = (CardLayout) getLayout();
        c.show(this, cardDisplayPanelName);
    }

    @Override
    public void showCardDisplayPanel() {
        CardLayout c = (CardLayout) getLayout();
        c.last(this);
    }

    @Override
    public ICardDisplayPanel getCardDisplayPanel() {
        return cardDisplayPanel;
    }

    @Override
    public IFreshStartPanel getFreshStartPanel() {
        return freshStartPanel;
    }
}
