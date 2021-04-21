package view.freshStartPanel;

import java.util.EventListener;

public interface IFreshStartPanelListener extends EventListener {
    void addAnotherClicked(Object sender);

    void loadFromFileClicked(Object sender);
}
