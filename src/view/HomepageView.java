package view;

import javax.swing.*;
import java.awt.*;

public class HomepageView extends JPanel {
    public HomepageView(){
        setLayout(new BorderLayout());

        // add credit
        add(addCredit(),BorderLayout.CENTER);
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

}
