package view;

import java.awt.event.ActionListener;

public interface IFreshStartPanel {
    void addLoadFromFileClickListener(ActionListener listener);

    void removeLoadFromFileClickListener(ActionListener listener);

    void addAddNewClickListener(ActionListener listener);

    void removeAddNewClickListener(ActionListener listener);
}
