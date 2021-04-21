package view;

import view.freshStartPanel.IFreshStartPanel;

public interface IDataPanel {
    ICardDisplayPanel getCardDisplayPanel();

    IFreshStartPanel getFreshStartPanel();

    void showCardDisplayPanel();

    void showFreshStartPanel();
}
