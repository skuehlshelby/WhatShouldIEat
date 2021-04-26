package view;

import view.freshStartPanel.IFreshStartPanel;

/**
 * @author Scott Kuehl-Shelby
 */
public interface IDataPanel {
    ICardDisplayPanel getCardDisplayPanel();

    IFreshStartPanel getFreshStartPanel();

    void showCardDisplayPanel();

    void showFreshStartPanel();
}
