package view;

import javax.swing.*;
import java.awt.*;

public class SidebarFrame extends JFrame {

    private static JFrame sidebarFrame = null; // singleton
    private static JPanel content = null;
    public SidebarFrame(JPanel ContentReplace){
        setUp(ContentReplace);
    }
    private void setUp(JPanel ContentReplace){
        if(sidebarFrame == null) {
            //Create and set up the window.
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //add sidebar
            SidebarView sidebar = new SidebarView();
            add(sidebar, BorderLayout.WEST);

            if(content == null) {
                content = ContentReplace;
                add(content, BorderLayout.CENTER);
            }
            //Display the window.
            sidebarFrame = this;
            pack();
            setSize(1000,800);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }
    public static JFrame getInstance(JPanel ContentReplace){
        sidebarFrame.getContentPane().removeAll();
        sidebarFrame.getContentPane().setLayout(new BorderLayout());
        SidebarView sidebar = new SidebarView();
        sidebarFrame.getContentPane().add(sidebar, BorderLayout.WEST);
        sidebarFrame.getContentPane().add(ContentReplace);
        sidebarFrame.revalidate();
        sidebarFrame.repaint();
        return sidebarFrame;
    }
}
