package view.freshStartPanel;

import java.util.EventListener;

/**
 * @author Scott Kuehl-Shelby
 */
public interface IFreshStartPanelListener extends EventListener {
    void addAnotherClicked(Object sender);

    void loadFromFileClicked(Object sender);
}
