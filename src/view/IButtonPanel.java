package view;

import java.awt.event.ActionListener;

public interface IButtonPanel {
    void addChooseClickListener(ActionListener listener);

    void removeChooseClickListener(ActionListener listener);

    void addSelectAllClickListener(ActionListener listener);

    void removeSelectAllClickListener(ActionListener listener);

    void addSelectNoneClickListener(ActionListener listener);

    void removeSelectNoneClickListener(ActionListener listener);

    void addAddAnotherClickListener(ActionListener listener);

    void removeAddAnotherClickListener(ActionListener listener);
}
