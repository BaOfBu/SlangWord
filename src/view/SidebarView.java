package view;

import controller.SidebarController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class SidebarView extends JPanel {
    private static String[] title = {"Search by keyword","Search by definition",
    "view history", "add", "edit", "delete", "reset", "random",
            "random keyword", "random definition"};
    public SidebarView() {
        setName("Sidebar");
        MouseListener listener = new SidebarController();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300,800));
        setMaximumSize(new Dimension(300,80));
        setMinimumSize(new Dimension(25,80));
        addTitle(this);
        for(String item: title){
            addAButton(item,this,listener);
        }
    }

    private void addTitle(Container container){
        JPanel button = new JPanel();
        String text = "SLANG DICTIONARY";
        button.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,20));
        button.setOpaque(true);
        button.setBackground(new Color(100, 149, 237));
        button.add(jlabel);
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
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

}
