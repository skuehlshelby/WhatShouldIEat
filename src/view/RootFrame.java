package view;

import javax.swing.*;
import java.awt.*;

public class RootFrame
{
    private final JFrame root;

    public RootFrame()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        root = new JFrame("What Should I Eat?");
        root.getContentPane().setLayout(new GridLayout());
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setSize(500, 500);
        root.setLocationRelativeTo(null);
    }

    public void setContent(JPanel content)
    {
        root.getContentPane().removeAll();
        root.getContentPane().add(content);
        root.getContentPane().revalidate();
        root.getContentPane().repaint();
    }

    public void show()
    {
        if(!root.isVisible())
        {
            root.setVisible(true);
            root.getContentPane().repaint();
        }
    }
}
