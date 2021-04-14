package view;

public interface IDataPanel {
    ICardDisplayPanel getCardDisplayPanel();

    IFreshStartPanel getFreshStartPanel();

    void showCardDisplayPanel();

    void showFreshStartPanel();
}
