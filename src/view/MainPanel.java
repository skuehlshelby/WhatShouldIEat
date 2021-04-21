package view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements IMainPanel {
    private final TitlePanel titlePanel;
    private final ButtonPanel buttonPanel;
    private final DataPanel dataPanel;

    public MainPanel() {
        titlePanel = new TitlePanel();
        buttonPanel = new ButtonPanel();
        dataPanel = new DataPanel();

        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());

        add(titlePanel, new GridBagConstraintBuilder(0, 0).fillHorizontally().spanXNumberOfColumns(2).rowWeight(GridBagConstraintBuilder.TINY).build());
        add(buttonPanel, new GridBagConstraintBuilder(0, 1).build());
        add(dataPanel, new GridBagConstraintBuilder(1, 1).build());
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
