package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstTimeStartup
{
    private final JPanel content;
    private final JButton start;
    private final JButton load;

    public FirstTimeStartup()
    {
        content = new JPanel();

        JLabel prompt = new JLabel("Add some of your favorite places to eat...");
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);

        start = ButtonFactory.makeButton("Start");

        load = ButtonFactory.makeButton("Load");

        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        content.add(Box.createHorizontalStrut(10));
        content.add(prompt);
        content.add(Box.createRigidArea(new Dimension(0, 5)));
        content.add(start);
        content.add(Box.createRigidArea(new Dimension(0, 5)));
        content.add(load);
        content.add(Box.createHorizontalStrut(10));
    }

    public void registerLoadClickListener(ActionListener listener)
    {
        load.addActionListener(listener);
    }

    public void registerStartClickListener(ActionListener listener)
    {
        start.addActionListener(listener);
    }

    public JPanel getContent()
    {
        return content;
    }
}
