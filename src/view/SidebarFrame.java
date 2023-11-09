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
            setLocationRelativeTo(null);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setVisible(true);
        }
    }
    public static JFrame getInstance(JPanel ContentReplace){
        sidebarFrame.getContentPane().remove(content);
        sidebarFrame.getContentPane().add(ContentReplace);
        sidebarFrame.validate();
        return sidebarFrame;
    }
}
