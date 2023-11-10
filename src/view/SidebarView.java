package view;

import controller.SidebarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class SidebarView extends JPanel {
    private static String[] title = {"SEARCH BY KEYWORD","SEARCH BY DEFINITION",
            "VIEW HISTORY", "ADD", "EDIT", "DELETE", "RESET", "RANDOM",
            "RANDOM QUIZ KEYWORD", "RANDOM QUIZ DEFINITION"};
    public SidebarView() {
        setName("Sidebar");
        MouseListener listener = new SidebarController();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300,800));
//        setMaximumSize(new Dimension(300,80));
//        setMinimumSize(new Dimension(25,80));
        addTitle(this,listener);
        for(String item: title){
            addAButton(item,this,listener);
        }
    }

    private void addTitle(Container container, MouseListener listener){
        JPanel button = new JPanel();
        button.addMouseListener(listener);
        String text = "SLANG DICTIONARY";
        button.setName("SLANG DICTIONARY");
        JLabel jlabel = new JLabel(text,JLabel.CENTER);
        jlabel.setFont(new Font("Verdana", Font.BOLD,20));
        button.setOpaque(true);
        button.setBackground(new Color(100, 149, 237));
        button.add(jlabel);
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

    private void addAButton(String text, Container container,MouseListener listener) {
        JPanel button = new JPanel();
        button.addMouseListener(listener);
        button.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,20));
        button.setOpaque(true);
        button.setBackground(new Color(100, 149, 237));
        button.add(jlabel);
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

}
