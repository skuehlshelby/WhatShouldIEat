package view;

import java.util.EventListener;

public interface IButtonPanelListener extends EventListener {
    void chooseClicked(Object sender);
    void selectAllClicked(Object sender);
    void selectNoneClicked(Object sender);
    void addAnotherClicked(Object sender);
}
