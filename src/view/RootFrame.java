package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Scott Kuehl-Shelby
 */
public class RootFrame extends JFrame
{

    public RootFrame(String title)
    {
        super(title);

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        getContentPane().setLayout(new GridLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    public void setContent(Component component) {
        getContentPane().removeAll();
        getContentPane().add(component);
        revalidate();
        repaint();
    }
}
