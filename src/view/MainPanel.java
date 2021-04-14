package view;

import javax.swing.*;

public class MainPanel extends JPanel {
    private final TitlePanel titlePanel;
    private final ButtonPanel buttonPanel;
    private final DataPanel dataPanel;

    public MainPanel() {
        titlePanel = new TitlePanel();
        buttonPanel = new ButtonPanel();
        dataPanel = new DataPanel();

        add(titlePanel);
        add(buttonPanel);
        add(dataPanel);
    }

    public TitlePanel getTitlePanel()
    {
        return titlePanel;
    }

    public IButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public DataPanel getDataPanel(){
        return dataPanel;
    }
}
