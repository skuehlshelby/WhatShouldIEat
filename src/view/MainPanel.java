package view;

import javax.swing.*;

public class MainPanel extends JPanel implements IMainPanel {
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

    @Override
    public TitlePanel getTitlePanel()
    {
        return titlePanel;
    }

    @Override
    public IButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    @Override
    public IDataPanel getDataPanel(){
        return dataPanel;
    }
}
