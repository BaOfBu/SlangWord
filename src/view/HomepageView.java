package view;

import javax.swing.*;
import java.awt.*;

public class HomepageView extends JFrame {
    public HomepageView(){

        //Create and set up the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane();

        //Display the window.
        pack();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private JPanel addCredit(){
        JPanel credit = new JPanel();
        String text = "Nguyễn Lê Quốc Khánh";
        credit.setName(text);
        JLabel jlabel = new JLabel(text);
        jlabel.setFont(new Font("Verdana", Font.BOLD,20));
        credit.setOpaque(true);
        credit.setBackground(new Color(255,255,255));
        credit.add(jlabel);
        return credit;
    }

    public void addComponentsToPane() {
        setLayout(new BorderLayout());
        // add sidebar
        SidebarView sidebar = new SidebarView();
        add(sidebar, BorderLayout.WEST);

        // add credit
        add(addCredit(),BorderLayout.CENTER);
    }
}
