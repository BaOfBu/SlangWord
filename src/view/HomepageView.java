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
        JPanel credit = new JPanel(new BorderLayout());
        String text = "21127073 - Nguyễn Lê Quốc Khánh";
        credit.setName(text);
        JLabel label = new JLabel(text,SwingConstants.CENTER);
        label.setFont(new Font("Verdana", Font.BOLD,25));
        label.setPreferredSize(new Dimension(700,100));
        label.setForeground(new Color(238, 78, 52));
        //label.setBackground(new Color(252, 237, 218));

        credit.setOpaque(true);
        credit.setBackground(new Color(255,255,255));
        credit.add(label,BorderLayout.NORTH);

        JTextPane introduction = new JTextPane();
        introduction.setBackground(new Color(64, 142, 198));
        introduction.setFont(new Font("Verdana", Font.BOLD,25));
        introduction.setForeground(new Color(122, 32, 72));
        introduction.setText("1.SEARCH BY KEYWORD\n\n2.SEARCH BY DEFINITION\n\n" +
                "3.VIEW HISTORY\n\n4.ADD SLANGWORD\n\n5.EDIT SLANGWORD\n\n6.DELETE SLANGWORD\n\n7.RESET SLANGWORD\n\n"+
                "8.RANDOM SLANGWORD\n\n9.RANDOM QUIZ KEYWORD\n\n10.RANDOM QUIZ DEFINITION");
        introduction.setPreferredSize(new Dimension(700,500));
        credit.add(introduction,BorderLayout.CENTER);
        return credit;
    }

}
